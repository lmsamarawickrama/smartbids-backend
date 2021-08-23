package org.saliam.smartbids.user.domain.service;

import org.saliam.smartbids.user.domain.entity.User;
import org.saliam.smartbids.user.domain.port.in.UserService;
import org.saliam.smartbids.user.domain.port.out.UserRepository;
import org.saliam.smartbids.user.domain.specification.UserValidator;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService
{
  private final UserRepository userRepository;

  private final UserValidator userValidator;

  private final PasswordEncoder encoder;

  public UserServiceImpl(final UserRepository userRepository,
                         final UserValidator userValidator,
                         final PasswordEncoder encoder)
  {
    this.userRepository = userRepository;
    this.userValidator = userValidator;
    this.encoder = encoder;
  }

  @Override
  public Optional<User> findByUsername(String username)
  {
    return userRepository.findByUsername(username);
  }

  @Override
  public User save(User user)
  {
    if (userValidator.isValid(user))
    {
      user.setPassword(encoder.encode(user.getPassword()));
      return userRepository.save(user);
    }
    throw new IllegalArgumentException(
        "User " + user.getUsername() + "is not Valid due to " + userValidator.brokenRules(user).next().getClass()
            .toString());

  }

  @Override
  public Optional<User> get(Long id)
  {
    return userRepository.get(id);
  }

  @Override
  public List<User> getAll(int page, int size)
  {
    return userRepository.getAll(page, size);
  }

  @Override
  public boolean existsByUsername(String username)
  {
    return userRepository.existsByUsername(username);
  }

  @Override
  public boolean existsByEmail(String email)
  {
    return userRepository.existsByEmail(email);
  }
}
