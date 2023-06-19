package carrosseminovos.lojadeseminovos.domain.veiculo;

import carrosseminovos.lojadeseminovos.domain.veiculo.foto.Fotos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "veiculo")
@Table(name = "veiculos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Veiculo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private String anoFabEMod;
    private String versao;
    private String cambio;
    private String qtdePortas;
    private String combustivel;
    private Integer km;
    private String placa;
    private Double preco;
    private String descricao;
    @OneToMany(mappedBy = "veiculo", cascade = CascadeType.REMOVE)
    private List<Fotos> urlFotos;

    public Veiculo(DadosCadastroVeiculo dados){
        this.marca = dados.marca();
        this.modelo = dados.modelo();
        this.anoFabEMod = dados.anoFabEMod();
        this.versao = dados.versao();
        this.cambio = dados.cambio();
        this.qtdePortas = dados.qtdePortas();
        this.combustivel = dados.combustivel();
        this.km = dados.km();
        this.placa = dados.placa();
        this.preco = dados.preco();
        this.descricao = dados.descricao();
        this.urlFotos = dados.urlFotos();
    }

}
