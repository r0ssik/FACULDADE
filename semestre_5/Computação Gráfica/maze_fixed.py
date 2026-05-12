import pygame
import sys
import random
from queue import PriorityQueue

# CONFIG
LARGURA = 600
LINHAS = 20
TAM = LARGURA // LINHAS

pygame.init()
tela = pygame.display.set_mode((LARGURA, LARGURA))
pygame.display.set_caption("Maze Solver - A*")

# CORES
FUNDO = (30, 30, 30)
AZUL = (0, 0, 255)
VERMELHO = (255, 0, 0)
VERDE = (0, 255, 0)
PRETO = (0, 0, 0)
BRANCO = (255, 255, 255)

# Convencao: i = coluna (eixo x), j = linha (eixo y)
# x = cell.i * TAM, y = cell.j * TAM
# top    = parede de cima  (lado com y menor)
# bottom = parede de baixo (lado com y maior)
# left   = parede esquerda (lado com x menor)
# right  = parede direita  (lado com x maior)

class Cell:
    def __init__(self, i, j):
        self.i = i
        self.j = j
        self.paredes = {"top": True, "bottom": True, "left": True, "right": True}
        self.visitado = False

    # necessario porque usamos Cell como chave de dicionario no A*
    def __lt__(self, outro):
        return False


def criar_grid():
    return [[Cell(i, j) for j in range(LINHAS)] for i in range(LINHAS)]


# ------------------- GERAR LABIRINTO -------------------
def gerar_labirinto(grid):
    stack = []
    atual = grid[0][0]
    atual.visitado = True

    while True:
        vizinhos_nv = []
        i, j = atual.i, atual.j

        # esquerda (i-1)
        if i > 0 and not grid[i-1][j].visitado:
            vizinhos_nv.append(grid[i-1][j])
        # direita (i+1)
        if i < LINHAS-1 and not grid[i+1][j].visitado:
            vizinhos_nv.append(grid[i+1][j])
        # cima (j-1)
        if j > 0 and not grid[i][j-1].visitado:
            vizinhos_nv.append(grid[i][j-1])
        # baixo (j+1)
        if j < LINHAS-1 and not grid[i][j+1].visitado:
            vizinhos_nv.append(grid[i][j+1])

        if vizinhos_nv:
            proximo = random.choice(vizinhos_nv)
            stack.append(atual)

            dx = atual.i - proximo.i   # diferenca horizontal
            dy = atual.j - proximo.j   # diferenca vertical

            if dx == 1:
                # proximo esta a ESQUERDA de atual
                atual.paredes["left"] = False
                proximo.paredes["right"] = False
            elif dx == -1:
                # proximo esta a DIREITA de atual
                atual.paredes["right"] = False
                proximo.paredes["left"] = False
            elif dy == 1:
                # proximo esta ACIMA de atual
                atual.paredes["top"] = False
                proximo.paredes["bottom"] = False
            elif dy == -1:
                # proximo esta ABAIXO de atual
                atual.paredes["bottom"] = False
                proximo.paredes["top"] = False

            atual = proximo
            atual.visitado = True

        elif stack:
            atual = stack.pop()
        else:
            break

    # abrir entrada (topo do canto sup esquerdo) e saida (base do canto inf direito)
    grid[0][0].paredes["top"] = False
    grid[LINHAS-1][LINHAS-1].paredes["bottom"] = False


# ------------------- DESENHAR -------------------
def desenhar(grid, caminho=None):
    tela.fill(BRANCO)

    espessura = 2
    for linha in grid:
        for cell in linha:
            x = cell.i * TAM
            y = cell.j * TAM

            if cell.paredes["top"]:
                pygame.draw.line(tela, PRETO, (x, y), (x + TAM, y), espessura)
            if cell.paredes["bottom"]:
                pygame.draw.line(tela, PRETO, (x, y + TAM), (x + TAM, y + TAM), espessura)
            if cell.paredes["left"]:
                pygame.draw.line(tela, PRETO, (x, y), (x, y + TAM), espessura)
            if cell.paredes["right"]:
                pygame.draw.line(tela, PRETO, (x + TAM, y), (x + TAM, y + TAM), espessura)

    if caminho:
        for cell in caminho:
            cx = cell.i * TAM + TAM // 2
            cy = cell.j * TAM + TAM // 2
            pygame.draw.circle(tela, VERDE, (cx, cy), TAM // 5)


def desenhar_pontos(inicio, fim):
    pygame.draw.circle(
        tela, VERDE,
        (inicio.i * TAM + TAM // 2, inicio.j * TAM + TAM // 2),
        TAM // 3
    )
    pygame.draw.circle(
        tela, VERMELHO,
        (fim.i * TAM + TAM // 2, fim.j * TAM + TAM // 2),
        TAM // 3
    )


# ------------------- VIZINHOS ACESSIVEIS -------------------
def vizinhos(cell, grid):
    lista = []
    i, j = cell.i, cell.j

    # CIMA -> j diminui
    if j > 0 and (not cell.paredes["top"]) and (not grid[i][j-1].paredes["bottom"]):
        lista.append(grid[i][j-1])

    # BAIXO -> j aumenta
    if j < LINHAS - 1 and (not cell.paredes["bottom"]) and (not grid[i][j+1].paredes["top"]):
        lista.append(grid[i][j+1])

    # ESQUERDA -> i diminui
    if i > 0 and (not cell.paredes["left"]) and (not grid[i-1][j].paredes["right"]):
        lista.append(grid[i-1][j])

    # DIREITA -> i aumenta
    if i < LINHAS - 1 and (not cell.paredes["right"]) and (not grid[i+1][j].paredes["left"]):
        lista.append(grid[i+1][j])

    return lista


def heuristica(a, b):
    return abs(a.i - b.i) + abs(a.j - b.j)


# ------------------- A* -------------------
def a_star(grid, inicio, fim):
    count = 0
    fila = PriorityQueue()
    fila.put((0, count, inicio))

    came_from = {}

    g_score = {cell: float("inf") for linha in grid for cell in linha}
    g_score[inicio] = 0

    f_score = {cell: float("inf") for linha in grid for cell in linha}
    f_score[inicio] = heuristica(inicio, fim)

    open_set_hash = {inicio}

    while not fila.empty():
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()

        atual = fila.get()[2]
        open_set_hash.remove(atual)

        if atual == fim:
            caminho = []
            while atual in came_from:
                caminho.append(atual)
                atual = came_from[atual]
            caminho.append(inicio)
            caminho.reverse()
            return caminho

        for vizinho in vizinhos(atual, grid):
            temp_g = g_score[atual] + 1

            if temp_g < g_score[vizinho]:
                came_from[vizinho] = atual
                g_score[vizinho] = temp_g
                f_score[vizinho] = temp_g + heuristica(vizinho, fim)

                if vizinho not in open_set_hash:
                    count += 1
                    fila.put((f_score[vizinho], count, vizinho))
                    open_set_hash.add(vizinho)

    return []


# ------------------- ANIMAR AGENTE -------------------
def animar_agente(caminho, inicio, fim, grid):
    for cell in caminho:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()

        desenhar(grid, caminho)
        desenhar_pontos(inicio, fim)

        x = cell.i * TAM + TAM // 2
        y = cell.j * TAM + TAM // 2
        pygame.draw.circle(tela, AZUL, (x, y), TAM // 5)

        pygame.display.update()
        pygame.time.delay(40)


# ------------------- MAIN -------------------
def main():
    grid = criar_grid()
    gerar_labirinto(grid)

    inicio = grid[0][0]
    fim = grid[LINHAS-1][LINHAS-1]

    caminho = []
    rodando = True

    while rodando:
        desenhar(grid, caminho)
        desenhar_pontos(inicio, fim)
        pygame.display.update()

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                rodando = False

            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_SPACE:
                    caminho = a_star(grid, inicio, fim)
                    animar_agente(caminho, inicio, fim, grid)
                if event.key == pygame.K_r:
                    # resetar
                    grid = criar_grid()
                    gerar_labirinto(grid)
                    inicio = grid[0][0]
                    fim = grid[LINHAS-1][LINHAS-1]
                    caminho = []

    pygame.quit()
    sys.exit()


if __name__ == "__main__":
    main()
