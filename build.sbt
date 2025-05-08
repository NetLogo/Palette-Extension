import org.nlogo.build.{ NetLogoExtension, ExtensionDocumentationPlugin }

enablePlugins(NetLogoExtension, ExtensionDocumentationPlugin)

version    := "2.0.1"
isSnapshot := true

netLogoVersion      := "7.0.0-beta1"
netLogoExtName      := "palette"
netLogoClassManager := "PaletteExtension"

Compile / javaSource := baseDirectory.value / "src" / "main"
javacOptions ++= Seq("-g", "-Xlint:deprecation", "-encoding", "us-ascii", "--release", "11")

scalaVersion := "3.7.0"
Test / scalaSource := baseDirectory.value / "src" / "test"
scalacOptions ++= Seq("-deprecation", "-unchecked", "-Xfatal-warnings", "-feature", "-encoding", "us-ascii", "-release", "11")
