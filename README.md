# Kanban


## Estructura - MVP
Elementos comunes:
* View: Conjunto de Activities, fragments y componentes de vistas. Le indica al Presenter los eventos realizados por el usuario.
* Contract: Interface para la comunicación entr el View y Presenter.
* Presenter: Es reponsable de la lógica y se comunica mediante la interfaz del Contract con la vista.
* Model: El Presenter le realiza llamadas a sus servicios tanto remotos como locales. La parte de Modelo no sabe del Presenter y se comunica con la aplicación mediante eventos (Eventbus).

La comunicación entre los tres componentes MVP se basa en una interfaz entre View Presenter y los eventos lanzados por el Model. Para aplicaciones simples basta con el framework EventBus utilizado en este ejemplo sin tener que usar RxAndroid.
De la misma manera se puede realizar una estructura MVVM usando el mismo framework teniendo en cuenta los eventos posibles a realizar crando tipos genericos para estos eventos.

La gestión de errores en las llamadas a las clases de presistencia tambien se gestionan con los eventos generados desde Model.



## Frameworks
* Retrofit
* Gson
* Eventbus
* Butteknife
* Room





