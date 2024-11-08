package br.com.dicionariofutebolistico.assembler;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import br.com.dicionariofutebolistico.controller.LoginController;
import br.com.dicionariofutebolistico.model.Login;

@Component
public class LoginModelAssembler implements RepresentationModelAssembler<Login, EntityModel<Login>> {

    @Override
    public EntityModel<Login> toModel(Login login) {
        return EntityModel.of(login,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LoginController.class).show(login.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LoginController.class).index(null)).withRel("login"));
    }
}
