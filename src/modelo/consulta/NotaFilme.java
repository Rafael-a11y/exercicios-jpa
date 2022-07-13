package modelo.consulta;
// Não é uma entidade.
public class NotaFilme 
{
	private double mediaFinal;

	public NotaFilme(double media) {
		super();
		this.mediaFinal = media;
	}

	public double getMedia() {
		return mediaFinal;
	}

	public void setMedia(double media) {
		this.mediaFinal = media;
	}
	
}
