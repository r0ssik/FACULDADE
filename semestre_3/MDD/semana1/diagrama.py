import matplotlib.pyplot as plt
import networkx as nx

def criar_diagrama_ocorrencias():
    G = nx.DiGraph()

    # Adicionar nós
    G.add_nodes_from(["Entidade 1", "Entidade 2", "Ocorrência 1", "Ocorrência 2"])

    # Adicionar arestas
    G.add_edges_from([("Entidade 1", "Ocorrência 1"), ("Entidade 2", "Ocorrência 2")])

    # Plotar o grafo
    plt.figure(figsize=(5, 4))
    pos = nx.spring_layout(G)
    nx.draw(G, pos, with_labels=True, node_color='lightblue', edge_color='black', node_size=2500, font_size=10)
    plt.title("Diagrama de Ocorrências")
    plt.savefig("/mnt/data/diagrama_ocorrencias_matplotlib.png")
    plt.close()

def criar_der_1n():
    G = nx.DiGraph()

    # Adicionar nós
    G.add_nodes_from(["Entidade A", "Entidade B", "Relacionamento"])

    # Adicionar arestas
    G.add_edges_from([("Entidade A", "Relacionamento"), ("Relacionamento", "Entidade B")])

    # Plotar o grafo
    plt.figure(figsize=(5, 4))
    pos = nx.spring_layout(G)
    nx.draw(G, pos, with_labels=True, node_color='lightgreen', edge_color='black', node_size=2500, font_size=10)
    plt.title("DER com Relacionamentos 1:n")
    plt.savefig("/mnt/data/der_1n_matplotlib.png")
    plt.close()

def criar_modelo_empregado_dependente():
    G = nx.DiGraph()

    # Adicionar nós
    G.add_nodes_from(["Pessoa", "Empregado", "Dependente"])

    # Adicionar arestas
    G.add_edges_from([("Pessoa", "Empregado"), ("Pessoa", "Dependente")])

    # Plotar o grafo
    plt.figure(figsize=(5, 4))
    pos = nx.spring_layout(G)
    nx.draw(G, pos, with_labels=True, node_color='lightcoral', edge_color='black', node_size=2500, font_size=10)
    plt.title("Modelo Modificado Empregado-Dependente")
    plt.savefig("/mnt/data/empregado_dependente_matplotlib.png")
    plt.close()

# Criar os diagramas
criar_diagrama_ocorrencias()
criar_der_1n()
criar_modelo_empregado_dependente()

("/mnt/data/diagrama_ocorrencias_matplotlib.png", "/mnt/data/der_1n_matplotlib.png", "/mnt/data/empregado_dependente_matplotlib.png")
