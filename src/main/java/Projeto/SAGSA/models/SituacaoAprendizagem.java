package Projeto.SAGSA.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "situacoes_aprendizagem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SituacaoAprendizagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(name = "unidade_curricular_id", nullable = false)
    private Long unidadeCurricularId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "instrutor_id", nullable = false)
    private Usuario instrutor;

    @Column(name = "turma_id")
    private Long turmaId;

    @Column(name = "tipo_estrategia", nullable = false, length = 50)
    private String tipoEstrategia;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contextualizacao;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String desafio;

    @Column(name = "resultados_esperados", columnDefinition = "TEXT", nullable = false)
    private String resultadosEsperados;

    @Column(name = "carga_horaria_sa", nullable = false)
    private Integer cargaHorariaSa;

    @Column(nullable = false)
    private Boolean compartilhada = false;

    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();
}
