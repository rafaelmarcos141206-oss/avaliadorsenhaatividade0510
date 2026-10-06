import java.util.Scanner;

public class App {

    public static String avaliarSenha(String senha) {

        // Verifica tamanho
        if (senha.length() < 8) {
            return "Dica: a senha deve ter pelo menos 8 caracteres.";
        }

        // Verifica número
        boolean temNumero = false;

        for (int j = 0; j < senha.length(); j++) {
            if (Character.isDigit(senha.charAt(j))) {
                temNumero = true;
                break;
            }
        }

        if (!temNumero) {
            return "Dica: Adicione pelo menos 1 número à sua senha.";
        }

        // Verifica senhas óbvias
        String[] senhasObvias = {
            "12345678",
            "senha123",
            "admin123"
        };

        for (String obvia : senhasObvias) {
            if (senha.equals(obvia)) {
                return "Alerta: senha muito óbvia!";
            }
        }

        // Verifica letra maiúscula
        boolean temCapslock = false;

        for (int c = 0; c < senha.length(); c++) {
            if (Character.isUpperCase(senha.charAt(c))) {
                temCapslock = true;
                break;
            }
        }

        if (!temCapslock) {
            return "Dica: Adicione pelo menos 1 letra maiúscula à sua senha.";
        }

        return "Sucesso! Sua senha cumpre todos os requisitos.";
    }

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        String resultado = "";

        while (!resultado.startsWith("Sucesso")) {

            System.out.print("Digite uma senha: ");
            String senha = leitor.next();

            resultado = avaliarSenha(senha);

            System.out.println(resultado);
        }

        System.out.println("Senha aceita! Programa encerrado.");

        leitor.close();
    }
}

