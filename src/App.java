import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        
// Passo 1 - Fazer conexão http (conectar com o site)e buscar os Top 250 filmes

String url = "https://raw.githubusercontent.com/lukadev08/lukadev08.github.io/main/apidata/imdbtop250moviesdata.json"; //Alternativo
URI endereco = URI.create(url);
var client = HttpClient.newHttpClient();
HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
String body = response.body();
System.out.println(body);




// Passo 2 - Extrair só os dados que vamos usar (Título/Poster/Classificação)


var parser = new JsonParser();  //Utilizado para separar partes do texto (parsear)
List<Map<String, String>> listaDeFilmes = parser.parse(body);
//System.out.println(listaDeFilmes.size()); ---> Size serve para enumerar a qtd de informações

//Passo 3 - Exibir e manipular os dados na ide
for (Map<String,String> filme : listaDeFilmes) { //for --> Para essa lista eu quero que imprima as informações que descrevi abaixo
    System.out.println("\n\nFilme: " + "\u001b[1m" +filme.get("title") + "\u001b[m");
    System.out.println("Link da Imagem: " + "\u001b[4m" + filme.get("image") + "\u001b[m");
    
    double classificacao = Double.parseDouble(filme.get("imDbRating"));
    int numeroEstrelas = (int) classificacao;
    for (int n = 1; n <= numeroEstrelas; n++){
        System.out.print("⭐️") ;
    }
    System.out.println("\u001b[46;1m \u001b[37m" + "Nota: " +  filme.get("imDbRating") + "\u001b[m");

       }
    }
}