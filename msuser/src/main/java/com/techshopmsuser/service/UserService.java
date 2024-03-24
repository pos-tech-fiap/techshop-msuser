package com.techshopmsuser.service;

import com.techshopmsuser.dto.UserDTO;
import com.techshopmsuser.entity.User;
import com.techshopmsuser.repository.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private IUserRepository userRepository;

    @Transactional(readOnly = true)
    public Page findAll(PageRequest pageRequest) {
        try {
            Page<User> user = userRepository.findAll(pageRequest);
            logger.info("Usuarios encontrados: {}", user.getTotalElements());
            return user.map(UserDTO::new);
        } catch (RuntimeException e) {
            logger.error("Falha ao buscar Usuarios : {}", e);
            throw new RuntimeException(e);
        }
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        var user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        logger.info("Usuarios encontrados: {}", user);
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO save(UserDTO userDTO) {
        try {
            User user = new User();
            mapperDtoToEntity(userDTO, user);
            logger.info("Usuario criados: {}", user);
            return new UserDTO(userRepository.save(user));
        } catch (Exception e) {
            logger.error("Falha ao criar Usuarios : {}", e);
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public UserDTO update(Long id, UserDTO userDTO) {
        try {
            User usuario = userRepository.getOne(id);
            mapperDtoToEntity(userDTO, usuario);
            logger.info("Usuarios atualizados com sucesso: {}", usuario);
            return new UserDTO(userRepository.save(usuario));
        } catch (NoSuchElementException e) {
            logger.error("Falha ao atualizar Usuarios : {}", e);
            throw new RuntimeException("Usuario não encontrado, id: " + id);
        }
    }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
            logger.info("Usuario removido com sucesso: {}");

        } catch (NoSuchElementException e) {
            logger.error("Falha ao  remover Usuario: {}", e);
            throw new RuntimeException("Usuario não encontrado, id: " + id);
        }
    }

    private void mapperDtoToEntity(UserDTO dto, User user) {
        user.setName(dto.getName());
        user.setCPF(dto.getCPF());
        user.setEmail(dto.getEmail());
        user.setMobile(dto.getMobile());
        user.setBirthDate(dto.getBirthDate());
        user.setAddress(dto.getAddress());
    }
}
