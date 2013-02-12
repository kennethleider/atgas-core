/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.atgas.core;

import java.util.UUID;

/**
 *
 * @author ken
 */
public class UUIDGenerator {
    public static String newID() {
        return UUID.randomUUID().toString();
    }

    public static void main(String... args) {
        System.out.println("\"" + newID() + "\"");
    }
}
