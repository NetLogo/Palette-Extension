enablePlugins(org.nlogo.build.NetLogoExtension, org.nlogo.build.ExtensionDocumentationPlugin)

version := "2.0.0"

netLogoExtName      := "palette"

netLogoClassManager := "PaletteExtension"

netLogoTarget :=
  org.nlogo.build.NetLogoExtension.directoryTarget(baseDirectory.value)

netLogoZipSources   := false

javaSource in Compile := baseDirectory.value / "src"

javacOptions ++= Seq("-g", "-Xlint:deprecation", "-Xlint:all", "-Xlint:-serial", "-Xlint:-path",
  "-encoding", "us-ascii")

resolvers      += "netlogo" at "https://dl.cloudsmith.io/public/netlogo/netlogo/maven/"
netLogoVersion := "6.2.0-d27b502"
isSnapshot := true
