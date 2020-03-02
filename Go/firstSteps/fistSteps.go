package main

import "fmt"

func main() {
	fmt.Println("Hello World!")
	beyondHello()
}

func beyondHello() {
	var x int

	x = 10
	y := 11

	sum, prod := learnMultiple(x, y)
	fmt.Println("sum:", sum, "prod:", prod)

}

func learnMultiple(x, y int) (sum, prod int) {
	return x + y, x * y
}

func learnTypes() {

	s := "Lernen Sie Go!"
	s2 := `eine "raw" Zeichenkette
kann Zeilenumbrüch enthalten.`

	g := "Σ"

	f := 3.14195

	c := 3 + 4i

	var u uint = 8


}
