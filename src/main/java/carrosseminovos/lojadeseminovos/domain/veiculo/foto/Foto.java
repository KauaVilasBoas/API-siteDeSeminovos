package carrosseminovos.lojadeseminovos.domain.veiculo.foto;

import carrosseminovos.lojadeseminovos.domain.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "foto")
@Table(name = "fotos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Foto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;

    @ManyToOne
    private Veiculo veiculo;

    public Foto(DadosFoto dados, Veiculo veiculo){
        this.url = dados.url();
        this.veiculo = veiculo;
    }

}
