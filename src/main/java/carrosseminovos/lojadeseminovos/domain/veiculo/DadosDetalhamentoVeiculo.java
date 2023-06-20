package carrosseminovos.lojadeseminovos.domain.veiculo;

import carrosseminovos.lojadeseminovos.domain.veiculo.foto.DadosFoto;
import carrosseminovos.lojadeseminovos.domain.veiculo.foto.Foto;

import java.util.List;

public record DadosDetalhamentoVeiculo(Long id, String marca, String modelo, String anoFabEMod, String versao, String cambio, Integer qtdePortas, String combustivel, Integer km, String placa, Double preco, String descricao, List<Foto> urlFotos) {

    public DadosDetalhamentoVeiculo(Veiculo veiculo){
        this(veiculo.getId(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getAnoFabEMod(), veiculo.getVersao(), veiculo.getCambio(), veiculo.getQtdePortas(), veiculo.getCombustivel(), veiculo.getKm(), veiculo.getPlaca(), veiculo.getPreco(), veiculo.getDescricao(), veiculo.getUrlFotos());
    }
}
