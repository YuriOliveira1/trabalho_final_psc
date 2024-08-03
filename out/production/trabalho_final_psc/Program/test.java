����   B w
      java/lang/Object <init> ()V  model/entities/CartaDeApoio 
 Yuri  Main Texto da Carta
     :(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V
      model/dao/impl/DaoFactory createCartaApoioDao ()Lmodel/dao/DAO;	      java/lang/System out Ljava/io/PrintStream;  TESTE 1 - INSERT
    ! " # java/io/PrintStream println (Ljava/lang/String;)V % & ' ( ) model/dao/DAO insert (Ljava/lang/Object;)V + TESTE 2 - FindById
 - . / 0 1 java/lang/Integer valueOf (I)Ljava/lang/Integer; % 3 4 5 findById '(Ljava/lang/Integer;)Ljava/lang/Object;
  7 " ) 9 TESTE 3 - FindAll % ; < = findAll ()Ljava/util/List; ? @ A B C java/util/List iterator ()Ljava/util/Iterator; E F G H I java/util/Iterator hasNext ()Z E K L M next ()Ljava/lang/Object; O TESTE 4 - DeleteById % Q R S 
deleteById (Ljava/lang/Integer;)V U TESTE 5 - UPDATE W 
Xablaummmm
  Y Z # setNomeEscritor % \ ] ) update _ Program/test Code LineNumberTable LocalVariableTable this LProgram/test; main ([Ljava/lang/String;)V ccd Lmodel/entities/CartaDeApoio; args [Ljava/lang/String; cc ccDao Lmodel/dao/DAO; list Ljava/util/List; LocalVariableTypeTable .Lmodel/dao/DAO<Lmodel/entities/CartaDeApoio;>; /Ljava/util/List<Lmodel/entities/CartaDeApoio;>; StackMapTable j 
SourceFile 	test.java ! ^           `   /     *� �    a       	 b        c d   	 e f  `  �     �� Y	� L� M� � ,+� $ � *� ,� ,� 2 � L� +� 6� 8� ,� : N-� > :� D � � J � :� � 6��� N� ,� ,� 2 � L,� ,� P � T� ,� ,� 2 � L+V� X,+� [ �    a   R              (  6  =  E  L  j  r  u  }  �  � ! � " � # � $ � % b   4  j  g h    � i j    � k h   � l m  L m n o  p      � l q  L m n r  s    � T  t  % ? E  �    u    v