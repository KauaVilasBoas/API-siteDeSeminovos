package carrosseminovos.lojadeseminovos.controller;

import carrosseminovos.lojadeseminovos.domain.veiculo.DadosCadastroVeiculo;
import carrosseminovos.lojadeseminovos.domain.veiculo.DadosListagemVeiculo;
import carrosseminovos.lojadeseminovos.domain.veiculo.filtros.DadosFiltrarPorCambio;
import carrosseminovos.lojadeseminovos.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    //C.R.U.D

    @PostMapping("/cadastrarVeiculo")
    @Transactional
    public ResponseEntity cadastrarVeiculo(@RequestBody @Valid DadosCadastroVeiculo dados) {

        var detalhamentoVeiculo = veiculoService.cadastrarVeiculo(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(detalhamentoVeiculo);


    }

    @GetMapping("/estoque")
    public ResponseEntity<Page<DadosListagemVeiculo>> listarVeiculos(@PageableDefault(size = 20, sort = {"preco"}) Pageable pageable) {

        var page = veiculoService.listagemVeiculos(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(page);

    }

    @GetMapping("/detalharVeiculo/{id}")
    public ResponseEntity detalharVeiculo(@PathVariable Long id) {

        var detalhamentoVeiculo = veiculoService.detalharVeiculo(id);
        return ResponseEntity.status(HttpStatus.OK).body(detalhamentoVeiculo);

    }

    @DeleteMapping("excluirVeiculo/{id}")
    public ResponseEntity excluirVeiculo(@PathVariable Long id) {

        veiculoService.excluirVeiculo(id);
        return ResponseEntity.noContent().build();

    }

    //FOTO

    @GetMapping("fotos/{id}")
    public ResponseEntity fotosDoVeiculo(@PathVariable Long id){
        var fotos = veiculoService.fotosDoVeiculo(id);
        return ResponseEntity.status(HttpStatus.OK).body(fotos);
    }


    //FILTROS

    @GetMapping("/filtrarPorCambio")
    public ResponseEntity filtraVeiculoPorCambio(@RequestBody @Valid DadosFiltrarPorCambio dados){

        var listaDeVeiculos = veiculoService.filtrarVeiculoPorCambio(dados);
        return ResponseEntity.status(HttpStatus.OK).body(listaDeVeiculos);

    }

    @GetMapping("/filtraPorKm")
    public ResponseEntity<Page<DadosListagemVeiculo>> filtraVeiculoPorKmCrescente(@PageableDefault(size = 20, sort = {"km"}) Pageable pageable){

        var page = veiculoService.filtrarVeiculo(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(page);

    }

    @GetMapping("/filtraPorAno")
    public ResponseEntity<Page<DadosListagemVeiculo>> filtraVeiculoPorAnoCrescente(@PageableDefault(size = 20, sort = {"anoFabEMod"}) Pageable pageable){

        var page = veiculoService.filtrarVeiculo(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(page);

    }



}
