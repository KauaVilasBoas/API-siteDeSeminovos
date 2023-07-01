package carrosseminovos.lojadeseminovos.service;

import carrosseminovos.lojadeseminovos.domain.veiculo.*;
import carrosseminovos.lojadeseminovos.domain.veiculo.filtros.DadosFiltrarPorCambio;
import carrosseminovos.lojadeseminovos.domain.veiculo.foto.DadosListagemFoto;
import carrosseminovos.lojadeseminovos.domain.veiculo.foto.Foto;
import carrosseminovos.lojadeseminovos.domain.veiculo.foto.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

@Service
@Transactional
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private FotoRepository fotoRepository;

    //C.R.U.D

    public DadosDetalhamentoVeiculo cadastrarVeiculo(DadosCadastroVeiculo dados) {

        var veiculo = new Veiculo(dados);
        veiculoRepository.save(veiculo);

        List<Foto> fotos = veiculo.getUrlFotos();
        fotoRepository.saveAll(fotos);

        return new DadosDetalhamentoVeiculo(veiculo);
    }

    public Page<DadosListagemVeiculo> listagemVeiculos(Pageable pageable) {

        var page = veiculoRepository.findAll(pageable).map(DadosListagemVeiculo::new);
        return page;

    }

    public void excluirVeiculo(Long idVeiculo) {

        var veiculo = veiculoRepository.getReferenceById(idVeiculo);
        veiculoRepository.delete(veiculo);

        if (veiculo.equals(null)) {
            throw new RuntimeException();
        }

    }

    public DadosDetalhamentoVeiculo detalharVeiculo(Long id) {
        var veiculo = veiculoRepository.getReferenceById(id);
        var fotos = fotoRepository.findAllByVeiculoId(id);
        return new DadosDetalhamentoVeiculo(veiculo);
    }

    //FOTO

    public Stream<DadosListagemFoto> fotosDoVeiculo(Long id) {
        var fotos = fotoRepository.findAllByVeiculoId(id).stream().map(DadosListagemFoto::new);
        return fotos;
    }

    //FILTROS

    public Stream<DadosListagemVeiculo> filtrarVeiculoPorCambio(DadosFiltrarPorCambio dados) {

        var listaVeiculos = veiculoRepository.findAllByCambioEquals(dados.cambio()).stream().map(DadosListagemVeiculo::new);
        return listaVeiculos;

    }

    public Page<DadosListagemVeiculo> filtrarVeiculo(Pageable pageable) {

        var page = veiculoRepository.findAll(pageable).map(DadosListagemVeiculo::new);
        return page;

    }

    public Veiculo atualizarVeiculo(DadosAtualizacaoVeiculo dados) {

        var veiculo = veiculoRepository.getReferenceById(dados.id());

        if (dados.marca() != null) veiculo.setMarca(dados.marca());

        if (dados.modelo() != null) veiculo.setModelo(dados.modelo());

        if (dados.anoFabEMod() != null) veiculo.setAnoFabEMod(dados.anoFabEMod());

        if (dados.versao() != null) veiculo.setVersao(dados.versao());

        if (dados.cambio() != null) veiculo.setCambio(dados.cambio());

        if (dados.qtdePortas() != null) veiculo.setQtdePortas(dados.qtdePortas());

        if (dados.combustivel() != null) veiculo.setCombustivel(dados.combustivel());

        if (dados.km() != null) veiculo.setKm(dados.km());

        if (dados.placa() != null) veiculo.setPlaca(dados.placa());

        if (dados.preco() != null) veiculo.setPreco(dados.preco());

        if (dados.descricao() != null) veiculo.setDescricao(dados.descricao());

        return veiculo;

    }
}
