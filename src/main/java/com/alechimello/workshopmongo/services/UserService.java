package com.alechimello.workshopmongo.services;

import com.alechimello.workshopmongo.domain.User;
import com.alechimello.workshopmongo.dto.UserDTO;
import com.alechimello.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.support.RepositoryMethodInvocationListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException(("Objeto não encontrado")));
    }

    public User insert(User user) {
        return repository.insert(user);
    }

    public User fromDTO(UserDTO  userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User update(User user) {
        User newUser = findById(user.getId());
        updateData(newUser, user);
        return repository.save(newUser);
    }
    public void updateData(User newUser, User oldUser) {
        newUser.setName(oldUser.getName());
        newUser.setEmail(oldUser.getEmail());
    }
}
