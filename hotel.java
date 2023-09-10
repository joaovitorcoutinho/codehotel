import java.util.*;

class Cliente {
    private String nome;
    private String sobrenome;
    private String email;

    public Cliente(String nome, String sobrenome, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
    }

    
}

class Reserva {
    private Cliente cliente;
    private int numeroDias;
    private double taxaDiaria;

    public Reserva(Cliente cliente, int numeroDias, double taxaDiaria) {
        this.cliente = cliente;
        this.numeroDias = numeroDias;
        this.taxaDiaria = taxaDiaria;
    }

    public double calcularTotal() {
        return numeroDias * taxaDiaria;
    }

    
}

class Hotel {
    private List<Cliente> clientes;
    private List<Reserva> reservas;

    public Hotel() {
        this.clientes = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public List<Reserva> listarReservas() {
        return reservas;
    }
}

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        Cliente cliente1 = new Cliente("João", "Silva", "joao@example.com");
        Cliente cliente2 = new Cliente("Maria", "Santos", "maria@example.com");

        hotel.adicionarCliente(cliente1);
        hotel.adicionarCliente(cliente2);

        Reserva reserva1 = new Reserva(cliente1, 3, 20.0);
        Reserva reserva2 = new Reserva(cliente2, 5, 25.0);

        double totalReserva1 = reserva1.calcularTotal();
        double totalReserva2 = reserva2.calcularTotal();

        System.out.println("Total da Reserva 1: R$" + totalReserva1);
        System.out.println("Total da Reserva 2: R$" + totalReserva2);

        hotel.adicionarReserva(reserva1);
        hotel.adicionarReserva(reserva2);

        List<Cliente> listaClientes = hotel.listarClientes();
        List<Reserva> listaReservas = hotel.listarReservas();

        System.out.println("\nLista de Clientes:");
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente.getNome() + " " + cliente.getSobrenome() + " - " + cliente.getEmail());
        }

        System.out.println("\nLista de Reservas:");
        for (Reserva reserva : listaReservas) {
            System.out.println("Cliente: " + reserva.getCliente().getNome() + " " + reserva.getCliente().getSobrenome());
            System.out.println("Dias: " + reserva.getNumeroDias());
            System.out.println("Total: R$" + reserva.calcularTotal());
            System.out.println();
        }
    }
}