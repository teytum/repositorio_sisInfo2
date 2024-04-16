<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
  // Aquí iría la lógica para procesar la solicitud de baja (enviar correo, actualizar base de datos, etc.)

  // Mostramos un mensaje de confirmación
  echo "<h2>Solicitud de baja enviada con éxito.</h2>";

  // Redireccionamos al usuario a la página de confirmación
  header("Location: confirmacion_baja.php");
  exit();
}
?>
