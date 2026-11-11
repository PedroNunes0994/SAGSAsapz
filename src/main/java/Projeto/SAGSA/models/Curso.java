package Projeto.SAGSA.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cursos")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(name = "tipo_curso", nullable = false, length = 50)
    private String tipoCurso; // EX: 'HABILITACAO_TECNICA'

    @Column(nullable = false)
    private Boolean ativo = true;
}