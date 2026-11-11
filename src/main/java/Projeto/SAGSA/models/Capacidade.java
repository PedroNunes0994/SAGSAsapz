package Projeto.SAGSA.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "capacidades")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Capacidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "unidade_curricular_id", nullable = false)
    private UnidadeCurricular unidadeCurricular;

    @Column(nullable = false, length = 30)
    private String tipo; // 'TECNICA' ou 'SOCIOEMOCIONAL'

    @Column(nullable = false, length = 30)
    private String dominio; // 'COGNITIVO', 'PSICOMOTOR', 'AFETIVO'

    @Column(columnDefinition = "TEXT", nullable = false)
    private String descricao;
}