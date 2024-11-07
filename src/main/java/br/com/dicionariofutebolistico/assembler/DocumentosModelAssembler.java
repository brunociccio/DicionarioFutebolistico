package br.com.dicionariofutebolistico.assembler;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import br.com.dicionariofutebolistico.controller.DocumentosController;
import br.com.dicionariofutebolistico.model.Documentos;

@Component
public class DocumentosModelAssembler implements RepresentationModelAssembler<Documentos, EntityModel<Documentos>> {

    @Override
    public EntityModel<Documentos> toModel(Documentos documento) {
        return EntityModel.of(documento,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DocumentosController.class).show(documento.getIdDocumento())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DocumentosController.class).index(null)).withRel("documentos"));
    }
}
