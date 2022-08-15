package com.example.baitap.controller;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ClassController {
    @Autowired
    ClassService classService;

    @RequestMapping(value = "class", method = RequestMethod.GET)
    public ResponseEntity<List<Tblclass>> findAll() {
        List<Tblclass> list = classService.findAll();
        if (list.size() == 0) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Tblclass>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "createClass", method = RequestMethod.POST)
    public ResponseEntity<Tblclass> save(@RequestBody Tblclass tblclass) {
        classService.save(tblclass);
        return new ResponseEntity<Tblclass>(tblclass, HttpStatus.OK);
    }

    @RequestMapping(value = "updateC", method = RequestMethod.PUT)
    public ResponseEntity<Tblclass> update(@PathParam("id") Integer id, @RequestBody Tblclass tblclass) {
        Tblclass oldClass = classService.findById(id);
        oldClass.setName(tblclass.getName());
        oldClass.setRoom(tblclass.getRoom());
        oldClass.setNote(tblclass.getNote());
        classService.save(oldClass);
        return new ResponseEntity<Tblclass>(tblclass, HttpStatus.OK);
    }

    @RequestMapping(value = "updateClass/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Tblclass> updateClass(@PathVariable(value = "id") Integer id, @RequestBody Tblclass tblclass) {
        Tblclass oldClass = classService.findById(id);
        oldClass.setName(tblclass.getName());
        oldClass.setRoom(tblclass.getRoom());
        oldClass.setNote(tblclass.getNote());
        classService.save(oldClass);
        return new ResponseEntity<Tblclass>(tblclass, HttpStatus.OK);
    }

    @RequestMapping(value = "deleteClass/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Tblclass> delete(@PathVariable(value = "id") Integer id) {
        classService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "findClass", method = RequestMethod.GET)
    public ResponseEntity<List<Tblclass>> findClassByName(@PathParam("name") String name) {
        List<Tblclass> list = classService.findAllByNameContainsIgnoreCase(name);
        if (list.size() == 0) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Tblclass>>(list, HttpStatus.OK);
    }
}