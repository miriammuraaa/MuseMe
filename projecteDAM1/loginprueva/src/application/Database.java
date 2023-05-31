package application;

import java.util.HashMap;
import java.util.Map;

public class Database {
    private Map<String, String> userCredentials;

    public Database() {
        // Inicializar la base de datos con algunos usuarios de ejemplo
        userCredentials = new HashMap<>();
        userCredentials.put("usuario1", "contrasena1");
        userCredentials.put("usuario2", "contrasena2");
    }

    public boolean checkCredentials(String username, String password, String email, String password2) {
        // Verificar si las credenciales del usuario son correctas
        if (userCredentials.containsKey(username)) {
            String storedPassword = userCredentials.get(username);
            return storedPassword.equals(password);
        }
        return false;
    }

    public void registerUser(String username, String password) {
        // Registrar un nuevo usuario en la base de datos
        if (!userCredentials.containsKey(username)) {
            userCredentials.put(username, password);
            System.out.println("Usuario registrado exitosamente.");
        } else {
            System.out.println("El usuario ya existe en la base de datos.");
        }
    }

    // Otros métodos para realizar operaciones en la base de datos

}

