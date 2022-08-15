package com.example.baitap.controller;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAllUser() {
        List<User> list = userService.findAll();
        if (list.size() == 0) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<User> save(@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<User> update(@PathParam("id") Integer id, @RequestBody User user) {
        User oldUser = userService.findById(id);
        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPhone(user.getPhone());
        userService.saveUser(oldUser);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Integer id, @RequestBody User user) {
        User oldUser = userService.findById(id);
        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPhone(user.getPhone());
        userService.saveUser(oldUser);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "deleteU/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> delete(@PathVariable(value = "id") Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "find", method = RequestMethod.GET)
    public ResponseEntity<List<User>> findUserByName(@PathParam("name") String name) {
        List<User> list = userService.findAllByNameContainsIgnoreCase(name);
        if (list.size() == 0) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }
}
