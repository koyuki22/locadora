package model.bean;

public class filme {
	private int idFilme;
	private String titulo;
	private int tempo;
	private boolean img3d;
	private boolean dublado;
	private String sinopse;
	private String categoria;
	
	public int getIdFilme() {
		return idFilme;
	}
	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	public boolean isImg3d() {
		return img3d;
	}
	public void setImg3d(boolean img3d) {
		this.img3d = img3d;
	}
	public boolean isDublado() {
		return dublado;
	}
	public void setDublado(boolean dublado) {
		this.dublado = dublado;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	

}
