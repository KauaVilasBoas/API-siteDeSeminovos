package carrosseminovos.lojadeseminovos.controller;

import carrosseminovos.lojadeseminovos.domain.veiculo.DadosCadastroVeiculo;
import carrosseminovos.lojadeseminovos.domain.veiculo.DadosDetalhamentoVeiculo;
import carrosseminovos.lojadeseminovos.domain.veiculo.Veiculo;
import carrosseminovos.lojadeseminovos.domain.veiculo.VeiculoRepository;
import carrosseminovos.lojadeseminovos.domain.veiculo.foto.Foto;
import carrosseminovos.lojadeseminovos.domain.veiculo.foto.FotoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/estoque/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private FotoRepository fotoRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrarVeiculo(@RequestBody @Valid DadosCadastroVeiculo dados){

        var veiculo = new Veiculo(dados);
        veiculoRepository.save(veiculo);

        List<Foto> fotos = veiculo.getUrlFotos();
        fotoRepository.saveAll(fotos);

        return ResponseEntity.status(HttpStatus.CREATED).body(new DadosDetalhamentoVeiculo(veiculo));
    }

}
