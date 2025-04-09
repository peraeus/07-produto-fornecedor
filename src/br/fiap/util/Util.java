package br.fiap.util;

import br.fiap.fornecedor.Fornecedor;
import br.fiap.produto.Produto;

import java.text.DecimalFormat;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;

public class Util {

    private Fornecedor[] fornecedor = new Fornecedor[5];
    private Produto[] produto = new Produto[5];
    private int indexProduto = 0;
    private int indexFornecedor = 0;

    // metodo para exibir o menu de opções
    public void menu() {
        int opcao;
        String menu = "1. Cadastrar Produto\n2. Pesquisar produto por nome\n3. Pesquisar fornecedor por CNPJ\n4. Finalizar";

        while(true) {
            opcao = parseInt(showInputDialog(menu));
            if(opcao == 4) {
                return;
            }
                    switch (opcao) {
                        case 1:
                            cadastrarProduto();
                            break;
                        case 2:
                            pesquisarProduto();
                            break;
                        case 3:
                            pesquisarFornecedor();
                            break;
                        default:
                            showInputDialog(null, "opção inválida");
                    }
                }



        }

        private void pesquisar() {
        Fornecedor fornecedor = pesquisarFornecedor();
        String msg = "";
        if (fornecedor != null) {
            msg += "Fornecedor: " + fornecedor.getNome() + "\n";
            msg += "CNPJ : " + fornecedor.getCnpj() + "\n";
            showInputDialog(null, msg);
        }
        }

    private void cadastrarProduto() {
        String nome;
        int quantidadeEstoque;
        double valorUnitario;
        Fornecedor fornecedor = pesquisarFornecedor();
        if (fornecedor == null) {
            fornecedor = cadastrarFornecedor();

        }
        nome = showInputDialog("Nome do produto");
        quantidadeEstoque = parseInt(showInputDialog("Quantidade em estoque"));
        valorUnitario = parseDouble(showInputDialog("Valor unitário"));
        produto[indexProduto++] = new Produto(nome, quantidadeEstoque,valorUnitario, fornecedor);
    }

    private Fornecedor cadastrarFornecedor() {
        Fornecedor fornecedor = null;
        long cnpj = parseLong(showInputDialog("CNPJ do fornecedor"));
        String nome = showInputDialog("Nome do fornecedor");
        fornecedor = new Fornecedor(nome, cnpj);
        this.fornecedor[indexFornecedor++] = fornecedor;
        return fornecedor;
    }

    private void pesquisarProduto() {
        DecimalFormat df = new DecimalFormat("0.00");
        String msg = "Produto não cadastrado";
        String nome = showInputDialog("Nome do produto");
        for (int i = 0; i < indexProduto; i++) {
            if (produto[i].getNome().equalsIgnoreCase(nome)) {
                msg = "";
                msg += "Nome do produto: " + nome + "\n";
                msg += "Valor unitário: " + df.format(produto[i].getValorUnitario()) + "\n";
                msg += "Fornecedor: " + produto[i].getFornecedor().getNome() + "\n";
            }
        }
    }

    private Fornecedor pesquisarFornecedor() {
        long cnpj = parseLong(showInputDialog("CNPJ do fornecedor"));
        for (int i = 0; i < indexFornecedor; i++) {
            if (fornecedor[i].getCnpj() == cnpj) {
                return fornecedor[i];
            }
        }
        showMessageDialog(null, "CNPJ " + cnpj + " não cadastrado.");
        return null;
    }

}
