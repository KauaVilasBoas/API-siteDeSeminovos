package carrosseminovos.lojadeseminovos.domain.veiculo.foto;

public record DadosListagemFoto(String url) {

    public DadosListagemFoto(Foto foto){
        this(foto.getUrl());
    }

}
