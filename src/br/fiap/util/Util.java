package br.fiap.util;

import br.fiap.fornecedor.Fornecedor;
import br.fiap.produto.Produto;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;


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


    private void cadastrarProduto() {

    }

    private void pesquisarProduto() {
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
