import java.util.Scanner;
import java.time.LocalTime;



public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int filasVehiculo =0;
    static int filasDesc = 0;
    static int filasUsuario = 0;
    static int filasVehiculoRent = 0;
    static int numIdCliente = 0;
    static int numIdDias =0;
    static int contaRenta = 0;

    static String [] vehiculoMarca = new String[100];
    static String [] vehiculoLinea = new String[100];
    static String [] vehiculoModelo = new String[100];
    static String [] vehiculoPlaca = new String[100];
    static double [] vehiculoCosto = new double[100];
    static int [] diasAlquiler = new int[100];

    static  int [] porcentajeDesc = new int[100];
    static String [] nombreUsuario = new String[100];
    static String [] apellidoUsuario = new String[100];
    static String [] nitUsuario = new String[100];
    static String [] marcaReporte = new String[100];
    static String [] anioRporte = new String[100];
    static double [] diasReporte = new double[100];



    public static void ingresoNuevoVehiculo ( ){

        System.out.println("bienvenido al sistema de gestion de vehiculos");
        System.out.println("Ingrese los datos del vehiculo por favor");

        boolean continuarIngreso = true;

        while (continuarIngreso){


            System.out.println("ingrese la marca del vehiculo:");
            String marcaVehiculo = scanner.next();
            System.out.println("ingrese la linea del vehiculo:");
            String lineaVehiculo = scanner.next();
            System.out.println("ingrese el modelo:");
            String modelVehiculo = scanner.next();

            boolean vtnPlaca = true;
            String placaVehiculo ="";

            while(vtnPlaca) {
                System.out.println("ingrese la placa del vehiculo:");
                boolean placaRepetida = false;
                placaVehiculo = scanner.next();
                for (int i = 0; i < filasVehiculo; i++) {

                    if (vehiculoPlaca[i].equals(placaVehiculo)) {
                        placaRepetida = true;
                    }

                }
                if (placaRepetida) {

                    System.out.println("La placa ya existe, por favor intente con otro valor");

                } else {
                    vtnPlaca = false;
                }
            }


            boolean doubleVlido = false;
            double costoDiaVehiculo = 0;

            while(!doubleVlido) {
                System.out.println("ingrese el costo por dia del vehiculo:");

                if (scanner.hasNextDouble()) {
                    costoDiaVehiculo = scanner.nextInt();
                    if(costoDiaVehiculo>0){
                        doubleVlido = true;
                    }
                    else{
                        System.out.println("el numero de costo1 debe ser mayor a 0");
                        doubleVlido = false;
                    }
                }
                else{
                    System.out.println("el numero debe ser un entero");
                    doubleVlido = false;
                    scanner.next();
                }
            }


            vehiculoMarca[filasVehiculo]=marcaVehiculo;
            vehiculoLinea[filasVehiculo]=lineaVehiculo;
            vehiculoModelo[filasVehiculo]=modelVehiculo;
            vehiculoPlaca[filasVehiculo]=placaVehiculo;
            vehiculoCosto[filasVehiculo]=costoDiaVehiculo;
            filasVehiculo++;
            System.out.println("vehiculo ingresado");




            String respuesta;
            boolean siNo;

            do {

                System.out.println("desea ingresar otro vehiculo s/n?");
                respuesta = scanner.next();
                if (respuesta.equalsIgnoreCase("s")) {

                    siNo = false;
                    continuarIngreso = true;

                } else if (respuesta.equalsIgnoreCase("n")) {

                    System.out.println("saliendo del registro de vehiculos");
                    siNo = false;
                    continuarIngreso = false;

                } else {

                    siNo = true;
                    System.out.println("respuesta invalida ingrese 's' o 'n'");

                }

            }while(siNo);

        }


    }

    public static void agregarDescuento (){
        String valorIng ="";
        boolean receptorBoo = true;

        while (receptorBoo){

            System.out.println("ingrese los datos de descuento:");

            boolean entradaAnio = false;
            int diasAlquilerEnt = 0;

            while(!entradaAnio) {
                System.out.println("numero de dias minimo de alquiler:");

                if (scanner.hasNextInt()) {
                    diasAlquilerEnt = scanner.nextInt();
                    if(diasAlquilerEnt>0){
                        entradaAnio = true;
                    }
                    else{
                        System.out.println("el numero de dias debe ser mayor a 0");
                        entradaAnio = false;
                    }
                }
                else{
                    System.out.println("el numero debe ser un entero");
                    entradaAnio = false;
                    scanner.next();
                }
            }
            boolean entradaPorcen = false;
            int porcenDesc = 0;
            while(!entradaPorcen) {

                System.out.println("porcentaje de descuento:");

                if (scanner.hasNextInt()) {
                    porcenDesc = scanner.nextInt();
                    if (porcenDesc > 0 && porcenDesc < 100) {
                        entradaPorcen = true;
                    } else {
                        System.out.println("el numero de dias debe ser mayor a 0 y menor a 99");
                        entradaPorcen = false;
                    }
                } else {
                    System.out.println("el numero debe ser un entero");
                    entradaPorcen = false;
                    scanner.next();
                }
            }

            diasAlquiler[filasDesc] = diasAlquilerEnt;
            porcentajeDesc[filasDesc] = porcenDesc;
            filasDesc ++;
            receptorBoo = false;




        }





    }


    public static void mostrarvehi (){

        System.out.println("resumen vehiculos ingresados");

        for (int i = 0; i < filasVehiculo ; i++ ){
            System.out.println("----------------------------------");
            System.out.println("Marca: "+vehiculoMarca[i]);
            System.out.println("Modelo: "+vehiculoModelo[i]);
            System.out.println("linea:" +vehiculoLinea[i]);
            System.out.println("placa: "+ vehiculoPlaca[i]);

        }

    }
    public static void ingresoUsu(){
        boolean estadoIngreso = true;
        while (estadoIngreso){
            System.out.println("ingrese su NIT para iniciar sesion o volver al menu con s");
            String nit= scanner.next();

            boolean busquedanit = false;
            for(int i = 0; i<filasUsuario; i++) {
                if (nit.equals(nitUsuario[i])) {
                    numIdCliente = i;

                    busquedanit = true;

                }
            }
            if(busquedanit){

                rentaVehiculo();
            }
            else{
                System.out.println("Este numero de NIT no esta asociado a ningun usuario");
            }

            String respuesta;
            boolean siNo;

            do {

                System.out.println("desea salir s/n?");
                respuesta = scanner.next();
                if (respuesta.equalsIgnoreCase("n")) {

                    siNo = false;
                    estadoIngreso = true;

                } else if (respuesta.equalsIgnoreCase("s")) {

                    System.out.println("saliendo del inicio de sesion");
                    siNo = false;
                    estadoIngreso = false;

                } else {

                    siNo = true;
                    System.out.println("respuesta invalida ingrese 's' o 'n'");

                }

            }while(siNo);

        }

    }

    public  static void registrarUsu (){

        System.out.println("bienvenido al registro de usuarios");
        System.out.println("para registrarse rellene los siguientes campos");
        boolean estadoRegistro = true;
        while(estadoRegistro){
            System.out.println("Nombre:");
            String nombreUsu = scanner.next();
            System.out.println("Apellido");
            String apellidoUsu = scanner.next();
            System.out.println("NIT");
            String nit = scanner.next();
            boolean nitExistente = false;
            for(int i = 0;i<filasUsuario;i++){
                if(nit.equals(nitUsuario[i])){
                    nitExistente = true;

                }
            }
            if(nitExistente){
                System.out.println("ya hay un usuario registrado con este NIT por favor intentar de nuevo");
            }
            else {
                System.out.println("usuario registrado");
                nombreUsuario[filasUsuario] = nombreUsu;
                apellidoUsuario[filasUsuario] = apellidoUsu;
                nitUsuario[filasUsuario] = nit;
                filasUsuario++;
            }
            String respuesta;
            boolean siNo;
            do {

                System.out.println("desea ingresar otro usuario s/n?");
                respuesta = scanner.next();
                if (respuesta.equalsIgnoreCase("s")) {

                    siNo = false;
                    estadoRegistro = true;

                } else if (respuesta.equalsIgnoreCase("n")) {

                    System.out.println("saliendo del registro de usuarios");
                    siNo = false;
                    estadoRegistro = false;

                } else {

                    siNo = true;
                    System.out.println("respuesta invalida ingrese 's' o 'n'");

                }

            }while(siNo);

        }
    }
    public static void rentaVehiculo(){
        String [] vehiculoLineaRent = new String[100];
        String [] vehiculoModeloRent = new String[100];
        String [] vehiculoPlacaRent = new String[100];
        double [] vehiculoCostoRent = new double[100];
        double [] vehiculoDiasRent = new double[100];
        double [] vehiculoPorcenRent = new double[100];
        double [] totalRentaDesc = new double[100];
        double [] totalRentaSinDesc = new double[100];
        int contaRentaSinDesc = 0;
        System.out.println("usuario ingresado");
        int opcion = 0;
        do {
            System.out.println("bienvenido al menu de renta de vehiculos, que desea hacer?");
            System.out.println("1). Rentar un vehiculo");
            System.out.println("2). cerrar sesion");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1: {

                    int opcionRenta;
                    boolean aplicadescuento = false;
                    double totalRentaUnica = 0;

                    do{
                        System.out.println("--------------vehiculos disponibles--------------");
                        System.out.println("");
                        for (int i = 0; i < filasVehiculo; i++) {
                            if (vehiculoPlaca[i].equals(vehiculoPlacaRent[i])) {
                                System.out.println("---------------------------");
                            } else {

                                System.out.println("  " + vehiculoMarca[i] + "  " + vehiculoLinea[i] + "  " + "Q" + vehiculoCosto[i] + "  " + vehiculoPlaca[i]);
                            }
                        }
                        System.out.println("------Descuentos aplicados segun dias de arrendamiento-----");
                        System.out.println("");
                        for (int i = 0; i < filasDesc; i++) {
                            System.out.println("  " + diasAlquiler[i] + "dias" + "  " + porcentajeDesc[i] + "%" + "  ");


                        }


                        System.out.println("elija una opcion");
                        System.out.println("1).reservar un vehiculo");
                        System.out.println("2).verificar orden actual");
                        System.out.println("3).finalizar renta");
                        opcionRenta = scanner.nextInt();



                        switch (opcionRenta) {

                            case 1: {
                                boolean placarent = true;
                                while (placarent) {
                                    System.out.println("escriba la placa del vehiculo que desea rentar");
                                    String placa = scanner.next();

                                    for (int i = 0; i < filasVehiculo; i++) {
                                        if (placa.equals(vehiculoPlaca[i])) {
                                            System.out.println("datos agregados a la factura");
                                            vehiculoModeloRent[i] = vehiculoModelo[i];
                                            vehiculoLineaRent[i] = vehiculoLinea[i];
                                            vehiculoPlacaRent[i] = vehiculoPlaca[i];
                                            vehiculoCostoRent [i] = vehiculoCosto[i];
                                            marcaReporte [i] = vehiculoMarca[i];
                                            anioRporte [i] = vehiculoModelo[i];
                                            filasVehiculoRent++;
                                            placarent = false;

                                        }
                                    }
                                    int diasRenta = 0;
                                    System.out.println("cuantos dias piensa rentar el vehiculo?");
                                    diasRenta = scanner.nextInt();
                                    totalRentaSinDesc[contaRenta] = diasRenta * vehiculoCostoRent[filasVehiculoRent-1];


                                    vehiculoDiasRent[contaRenta] = diasRenta;
                                    diasReporte [contaRenta] = diasRenta;
                                    for(int i = 0; i<filasDesc ; i++){
                                        if(diasRenta == (diasAlquiler[i])){
                                            numIdDias = i;
                                            vehiculoPorcenRent [contaRenta] = porcentajeDesc[numIdDias];
                                            aplicadescuento = true;
                                            break;

                                        }
                                    }
                                    if(aplicadescuento){

                                        totalRentaDesc[contaRenta] = calculoDiasPorcentaje(numIdDias,filasVehiculoRent,vehiculoCostoRent);
                                        contaRenta++;
                                    }
                                    else{
                                        totalRentaDesc[contaRenta] = diasRenta * vehiculoCostoRent[filasVehiculoRent-1];
                                        contaRenta++;
                                    }
                                    for(int i = 0; i<contaRenta;i++){
                                        System.out.println(+totalRentaSinDesc[i]);
                                    }
                                }
                                break;
                            }
                            case 2: {
                                System.out.println("vehiculos en espera de cierre de factura");
                                for (int i = 0; i < filasVehiculoRent; i++) {
                                    System.out.println("  " + vehiculoModeloRent[i] + " " + vehiculoLineaRent[i] + "  " + vehiculoPlacaRent[i]);
                                }
                                break;

                            }
                            case 3: {
                                LocalTime horaFactura = LocalTime.now();
                                System.out.println("-------------------Bytecar-------------------");
                                System.out.println("Cliente: " + nombreUsuario[numIdCliente]);
                                System.out.println("Nit: " + nitUsuario[numIdCliente]);
                                System.out.println("Facturado a las: "+horaFactura);
                                System.out.println("vehiculos rentados");
                                for (int i = 0; i < filasVehiculoRent; i++) {
                                    System.out.println("  " + vehiculoModeloRent[i] + " " + vehiculoLineaRent[i] + "  " + vehiculoPlacaRent[i]+" " + vehiculoDiasRent[i]+" "+totalRentaSinDesc[i]);

                                }
                                System.out.println("subtotal");
                                double subTotal = 0;
                                double subSubTotal = 0;
                                for(int i = 0; i<contaRenta; i++){

                                    subTotal = totalRentaSinDesc[i];
                                    subSubTotal = subSubTotal + subTotal;


                                }
                                System.out.println("monto subtotal: "+subSubTotal);


                                if(aplicadescuento){
                                    for(int i = 0; i<contaRenta ; i++){

                                        System.out.println("Auto: "+vehiculoLineaRent[i]+" porcentaje descuento "+vehiculoPorcenRent[i]);

                                    }

                                }
                                else {
                                    System.out.println("no aplica descuento");
                                }
                                System.out.println("total (con descuento si es que aplicara)");
                                double totalFinal = 0;
                                double totalTotalFinal = 0;
                                for (int i = 0; i <contaRenta; i++){
                                    totalFinal = totalRentaDesc[i];
                                    totalTotalFinal = totalTotalFinal + totalFinal;
                                }
                                System.out.println("total: "+totalTotalFinal);
                            }
                        }
                    }while(opcionRenta !=3);
                }
            }
        }while(opcion != 2);

    }

    public static double calculoDiasPorcentaje(int filasDias, int filasDiasVehi, double rentaCostoVehi[]){
        double costoDia = rentaCostoVehi[filasDiasVehi-1];
        double Dias = diasAlquiler[filasDias];
        double porcento = porcentajeDesc[filasDias];

        double costoxDia = costoDia*Dias;
        double descuento = (costoxDia*porcento)/100;
        double resultado = costoxDia-descuento;

        return resultado;
    }

    public static void reportes (){
        int diasPorMarca = 0;
        int contador = 1;
        double sumaDias = 0;
        double sumaSumaDias = 0;
        System.out.println("-------------------------------------------");
        System.out.println("Reporte vehiculos por marca");
        System.out.println("marca"+"  "+"dias");
        for(int i = 0; i< filasVehiculoRent; i++ ){

            System.out.println(marcaReporte[i]+"  "+diasReporte[i]);
            sumaDias = diasReporte [i];
            sumaSumaDias = sumaSumaDias + sumaDias;



        }
        System.out.println("total de dias por marca: "+sumaSumaDias);

        double sumaDias2 = 0;
        double sumaSumaDias2 = 0;
        System.out.println("-------------------------------------------");
        System.out.println("Reporte vehiculos por modelo");
        System.out.println("modelo"+"  "+"dias");
        for(int i = 0; i< filasVehiculoRent; i++ ){

            System.out.println(anioRporte[i]+"  "+diasReporte[i]);
            sumaDias2 = diasReporte [i];
            sumaSumaDias2 = sumaSumaDias2 + sumaDias2;



        }
        System.out.println("total de dias por modelo: "+sumaSumaDias2);

    }
    public static void mostrarAutos (){
        System.out.println("  "+"Marca"+"  "+"Modelo"+"  "+"Linea"+"  "+"placa"+"  "+"Costo");

        for(int i = 0; i<filasVehiculo; i++){

            System.out.println("  "+vehiculoMarca[i]+"  "+vehiculoModelo[i]+"  "+vehiculoLinea[i]+"  "+vehiculoPlaca[i]+"  "+vehiculoCosto[i]);

        }

    }



    public static void main(String[] args) {

        String nombreAdmin = "Lilimon";
        String contraAdmin = "hola";
        int recfilas;




        int opcionRol = 0;

        do {
            System.out.println("Bienvenido al menu");
            System.out.println("Elija su rol");
            System.out.println("1. Admin");
            System.out.println("2. Usuario");
            System.out.println("3. Salir");
            boolean vtnRol = true;
            while(vtnRol) {
                if (scanner.hasNextInt()) {

                    opcionRol = scanner.nextInt();
                    if (opcionRol > 0 && opcionRol<= 3){
                        vtnRol = false;
                    }
                    else{
                        System.out.println("ingrese una opcion valida 1-3");
                    }
                }
                else{
                    System.out.println("el valor debe ser un numero");
                    scanner.next();
                }
            }

            if (opcionRol == 1){
                scanner.nextLine();

                String credAdminNombre;
                String credAdminContra;


                System.out.println("Ingrese sus credenciales");
                System.out.println("nombre de usuario:");
                credAdminNombre = scanner.nextLine();
                System.out.println("Ingrese su contrasenia");
                credAdminContra = scanner.nextLine();



                if (credAdminNombre.equals(nombreAdmin) && credAdminContra.equals(contraAdmin)){

                    int opcionAdmin = 0;

                    do {

                        System.out.println("Bienvenido"+nombreAdmin);
                        System.out.println("que desea hacer?");
                        System.out.println("1. Ingresar un nuevo vehiculo al inventario");
                        System.out.println("2. Agregar descuentos especiales según la cantidad de días que se arrende un\n" +
                                "vehículo ");
                        System.out.println("3). Realizar reportes");
                        System.out.println("4). ver listado de vehiculos");
                        System.out.println("5). Volver al menu principal");
                        boolean vtnAdminop = true;
                        while(vtnAdminop) {
                            if (scanner.hasNextInt()) {
                                opcionAdmin = scanner.nextInt();
                                if (opcionAdmin > 0 && opcionAdmin <= 5) {
                                    vtnAdminop = false;


                                }
                                else{
                                    System.out.println("el valor debe ser mayor a 0 y menor o igual que 5, intente de nuevo");

                                }
                            }
                            else{
                                System.out.println("el valor no es un numero, intentelo de nuevo");
                                scanner.next();
                            }
                        }

                        switch (opcionAdmin){

                            case 1:{

                                ingresoNuevoVehiculo();

                                System.out.println(+filasVehiculo);

                                break;
                            }
                            case 2:{
                                agregarDescuento();
                                break;
                            }
                            case 3:{
                                reportes();
                                break;
                            }
                            case 4:{
                                mostrarAutos();
                            }

                        }
                    } while (opcionAdmin != 5);


                }
                else{
                    System.out.println("los datos ingresados no concuerdan");
                }

            }
            else{

                if (opcionRol == 2){
                    int opcionUsu = 0;
                    do {
                        System.out.println("bienvenido al menu de usuario, que desea hacer?");
                        System.out.println("1). Iniciar sesion");
                        System.out.println("2). Registrarse");
                        System.out.println("3). Regresar");

                        boolean vtnUsunop = true;
                        while (vtnUsunop) {
                            if (scanner.hasNextInt()) {
                                opcionUsu = scanner.nextInt();
                                if (opcionUsu > 0 && opcionUsu <= 3) {
                                    vtnUsunop = false;


                                } else {
                                    System.out.println("el valor debe ser mayor a 0 y menor o igual que 5, intente de nuevo");

                                }
                            } else {
                                System.out.println("el valor no es un numero, intentelo de nuevo");
                                scanner.next();
                            }
                        }
                        switch (opcionUsu) {
                            case 1: {

                                ingresoUsu();
                                break;

                            }
                            case 2: {
                                registrarUsu();

                                break;
                            }

                        }
                    }while(opcionUsu != 3);

                }

            }
        }while (opcionRol !=3);





    }
}

