import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GerandoFigurinhas {
    

    /**
     * @param inputStream
     * @param nomeArquivo
     * @throws Exception
     */
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

/*InputStream inputStream = new FileInputStream(new File("entrada/filme-maior.jpg"));
  InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYT
     c0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();*/
       
       
        // Passo 1- Ler a imagem
        BufferedImage imagemOriginal = ImageIO.read(new File("imagens/ST4"));

        // cria nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);


        // copiar a imagem original pra novo imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null); //desenhar uma imagem em outra imagem
        // estamos usando a imagem ORIGINAL, o drawImage é como se fosse uma caneta para desenhar na imagem 

     
        // configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 100);
        graphics.setColor(Color.RED);
        graphics.setFont(fonte);


        // escrever uma frase na nova imagem
        graphics.drawString("1º STICKER", 250, novaAltura - 55);


        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));
        
       }
    }
    