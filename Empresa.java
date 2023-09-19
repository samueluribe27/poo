import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.String;

public class Empresa {
    public String nombre;
    public String pais;
    public String anioFundacion;
    public String direccion;
    public double ingresos;
    public String horario;
    public List<Registro>listaregistros;
    public List<Vehiculo>listavehiculos;
    public List<Cliente> listaClientes;

    public Empresa(String nombre, String pais, String anioFundacion, String direccion, double ingresos, String horario) {
       listavehiculos=new ArrayList<>();
       listaregistros=new ArrayList<>();
       listaClientes=new ArrayList<>();

        this.nombre = nombre;
        this.pais = pais;
        this.anioFundacion = anioFundacion;
        this.direccion = direccion;
        this.ingresos = ingresos;
        this.horario = horario;

    }
    List<Object>recibo = new ArrayList<>();
    public void mostrarRegistros(){
        for (Registro registro:listaregistros) {
            System.out.println(registro.toString());

        }
    }
    public void mostrarVehiculosDisponibles(){
        for (Vehiculo vehiculo:listavehiculos) {
            System.out.println(vehiculo.toString());

        }
    }
    public void alquilarVehiculo() {
        mostrarVehiculosDisponibles();



        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el índice del vehículo que desea alquilar:");
        int indiceVehiculo = scanner.nextInt();
        recibo.add("indice del vehiculo: " + indiceVehiculo);

        if (indiceVehiculo >= 0 && indiceVehiculo < listavehiculos.size()) {
            Vehiculo vehiculoAlquilado = listavehiculos.get(indiceVehiculo);

            System.out.println("Ingrese el ID del cliente que alquilará el vehículo:");
            String idCliente = scanner.next();

        recibo.add("id del cliente " + idCliente);
            Cliente cliente = encontrarClientePorID(idCliente);

            if (cliente != null) {
                System.out.println("Ingrese la duración del alquiler en días:");
                int diasRentados = scanner.nextInt();

                Registro nuevoAlquiler = new Registro(cliente, vehiculoAlquilado, diasRentados);
                listaregistros.add(nuevoAlquiler);
            recibo.add("dias rentado: "+ diasRentados);
                vehiculoAlquilado.setDisponible(false);
                System.out.println("Alquiler registrado con éxito.");
                for(Registro registro : listaregistros){
                    double ingresos = registro.calcularPrecio();



                System.out.println("Factura: \n" + recibo.get(0) + "\n" + recibo.get(1) + "\n" + recibo.get(2));
                System.out.println("el valor a pagar es : " + ingresos);

                }

            } else { System.out.println("Cliente no encontrado.");
            }
        } else {
            System.out.println("Índice de vehículo no válido.");
        }
    }
    public Cliente encontrarClientePorID(String id) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }
    public void calcularIngresos() {
        double totalIngresos = 0.0;

        for (Registro registro : listaregistros) {
            totalIngresos += registro.calcularPrecio();
        }

        System.out.println( "Ingresos totales de la empresa: $" + totalIngresos);
    }
    public void añadirCliente(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del cliente:");
        String nombre = sc.nextLine();
        recibo.add("Nombre del cliente: " + nombre);
        System.out.println("Ingrese el apellido del cliente:");
        String apellido = sc.nextLine();
        System.out.println("Ingrese el ID del cliente:");
        String id = sc.nextLine();
        System.out.println("Ingrese la edad del cliente:");
        int edad = sc.nextInt();

        if(edad>=18){

        Cliente nuevoCliente = new Cliente(nombre, apellido, id, edad);
        listaClientes.add(nuevoCliente);

        System.out.println("Cliente agregado con éxito.");
        }else System.out.println("El cliente es menor de edad, por lo tanto no puede alquilar ningun vehiculo en nuestra empresa");

    }

    public void agregarBicicleta(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el color de la bicicleta");
        String color=sc.nextLine();
        System.out.println("Ingrese la marca de la bibicleta");
        String marca=sc.nextLine();
        System.out.println("Ingrese el año de la bicicleta");
        String año=sc.nextLine();
        System.out.println("Ingrese el tipo de la bicicleta");
        String tipo=sc.nextLine();
        System.out.println("Ingrese el precio por día que cuesta alquilar la bicicleta");
        int precioa=sc.nextInt();
        System.out.println("Ingrese el material de la bicicleta");
        String material=sc.nextLine();

        Bicicleta nuevaBicicleta=new Bicicleta(color,marca,año,precioa,tipo,material);
        listavehiculos.add(nuevaBicicleta);

        System.out.println("Bicicleta agregada con exito");

    }
    public void agregarScooter(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el color de la Scooter");
        String color=sc.nextLine();
        System.out.println("Ingrese la marca de la Scooter");
        String marca=sc.nextLine();
        System.out.println("Ingrese el año de la Scooter");
        String año=sc.nextLine();
        System.out.println("Ingrese el precio por día que cuesta alquilar la scooter");
        int precioa=sc.nextInt();
        System.out.println("Ingrese la potencia del motor");
        double potenciaMotor=sc.nextDouble();
        System.out.println("Ingrese la autonomia de la Scooter");
        int autonomia=sc.nextInt();
        System.out.println("Ingrese la velocidad maxima");
        int velocidadMaxima=sc.nextInt();

        Scooter nuevaScooter=new Scooter(color,marca,año,precioa,potenciaMotor,autonomia,velocidadMaxima);
        listavehiculos.add(nuevaScooter);

        System.out.println("Scooter agregada con exito");

    }

}
