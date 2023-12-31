package carrosseminovos.lojadeseminovos.domain.veiculo;

public record DadosListagemVeiculo(Long id, String marca, String modelo, String anoFabEMod, String versao, String cambio, Integer km, Double preco) {

    public DadosListagemVeiculo(Veiculo veiculo){
        this(veiculo.getId(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getAnoFabEMod(), veiculo.getVersao(), veiculo.getCambio(), veiculo.getKm(), veiculo.getPreco());
    }

}
