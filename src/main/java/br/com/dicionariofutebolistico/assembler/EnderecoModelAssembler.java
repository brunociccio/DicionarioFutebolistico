package br.com.dicionariofutebolistico.assembler;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import br.com.dicionariofutebolistico.controller.EnderecoController;
import br.com.dicionariofutebolistico.model.Endereco;

@Component
public class EnderecoModelAssembler implements RepresentationModelAssembler<Endereco, EntityModel<Endereco>> {

    @Override
    public EntityModel<Endereco> toModel(Endereco endereco) {
        return EntityModel.of(endereco,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EnderecoController.class).show(endereco.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EnderecoController.class).index(null)).withRel("endereco"));
    }
}
