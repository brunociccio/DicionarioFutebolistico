package br.com.dicionariofutebolistico.assembler;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import br.com.dicionariofutebolistico.controller.CadastroController;
import br.com.dicionariofutebolistico.model.Cadastro;

@Component
public class CadastroModelAssembler implements RepresentationModelAssembler<Cadastro, EntityModel<Cadastro>> {

    @Override
    public EntityModel<Cadastro> toModel(Cadastro cadastro) {
        return EntityModel.of(cadastro,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CadastroController.class).show(cadastro.getIdUsuario())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CadastroController.class).index(null)).withRel("cadastro"));
    }
}
