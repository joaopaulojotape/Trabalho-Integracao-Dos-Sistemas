package com.chocolate;

public class ClienteC {
    public boolean validarCliente(Cliente cliente) {
        if (isNomeValido(cliente)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isNomeValido(Cliente cliente) {
        if ((cliente.getName().isEmpty()) || (cliente.getName().length() < 3)) {
            return false;
        }
        return true;
    }
}
