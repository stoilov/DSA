/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package squirrels;

/**
 *
 * @author stoilov
 */
public class Test {

    public static void main(String[] args) {
        Tree squirrels = new Tree();
        squirrels.insertNode("George");
        squirrels.insertNode("Ivan");
        squirrels.insertNode("Pesho");
        squirrels.insertNode("Peter");
        squirrels.insertNode("Ivaylo");
        squirrels.insertNode("Ivelin");
        squirrels.insertNode("Iliya");
        
//        squirrels.inorderTraversal();
        
        squirrels.inorderSearch("Iv");
    }

}
