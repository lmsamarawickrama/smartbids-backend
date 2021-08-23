package org.saliam.smartbids.user.domain.port.out;

import org.saliam.smartbids.user.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository
{
  Optional<User> findByUsername(String username);

  User save(User user);

  boolean existsByUsername(String username);

  boolean existsByEmail(String email);

  Optional<User> get(Long id);

  List<User> getAll(int page, int size);
}
