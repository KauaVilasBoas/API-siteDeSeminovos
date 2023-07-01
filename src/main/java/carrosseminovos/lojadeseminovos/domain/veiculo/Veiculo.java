package carrosseminovos.lojadeseminovos.domain.veiculo;

import carrosseminovos.lojadeseminovos.domain.veiculo.foto.DadosFoto;
import carrosseminovos.lojadeseminovos.domain.veiculo.foto.Foto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "veiculo")
@Table(name = "veiculos")
@Getter
@Setter
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
    private Integer qtdePortas;
    private String combustivel;
    private Integer km;
    private String placa;
    private Double preco;
    private String descricao;

    @OneToMany(mappedBy = "veiculo", cascade = CascadeType.REMOVE)
    private List<Foto> urlFotos;

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

        List<Foto> fotos = new ArrayList<>();
        if (dados.urlFotos() != null) {
            for (DadosFoto dadosFoto : dados.urlFotos()) {
                fotos.add(new Foto(dadosFoto, this));
            }
        }
        this.urlFotos = fotos;
    }

}
