package br.com.dicionariofutebolistico.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "TB_DICIOFUT_DOCUMENTOS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Documentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocumento;

    @NotBlank(message = "Nome do documento é obrigatório")
    private String nomeDocumento;

    @NotBlank(message = "Tipo do documento é obrigatório")
    private String tipoDocumento;

    private String descricao;

    @NotNull(message = "Data de emissão é obrigatória")
    private LocalDate dataEmissao;

    private LocalDate dataValidade;

    @NotBlank(message = "URL do documento é obrigatória")
    private String urlDocumento;

    @NotNull(message = "ID da empresa é obrigatório")
    private Long idEmpresa;
}