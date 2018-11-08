#include "PalindromeTester.h"


PalindromeTester::PalindromeTester(void)
{
}


PalindromeTester::~PalindromeTester(void)
{
}

void PalindromeTester::runTests()
{
	cout << ("testing PalindromeDetector...") << flush;
	Palindrome p1;
	assert(!p1.isPalindrome("abc"));//not pal
	assert(!p1.isPalindrome("big not     pal&ind%om@e"));//not pal
	assert(p1.isPalindrome("bob"));//is pal
	assert(p1.isPalindrome("qpwoeiruurieowpq")); //is pal
	assert(p1.isPalindrome("b#ob% b*ob. b,ob,,,")); //is pal while ignoring symblos
	assert(!p1.isPalindrome(""));//not pal
	assert(p1.isPalindrome("12321"));
	assert(!p1.isPalindrome("23745980"));
	assert(p1.isPalindrome("hanah, 101, &HaNaH")); //more should ignore symblols
	assert(p1.isPalindrome("12lol21"));//nums and letters, is pal
	assert(p1.isPalindrome("lol101lol"));//letters then nums
	assert(!p1.isPalindrome("$^&%,.,;][}{"));//not pal, should ignore symbles
	assert(!p1.isPalindrome(" $^ &%,.,   ;][ }{  "));//not pal, should ignore symbosl
	assert(!p1.isPalindrome("         "));//not pal, should ignore spaces
	cout << "passed!" << endl;
	cout << "detecting Drawn Onward Palindromes..." << endl;
	Palindrome p9("somepalindromes.txt","PalindromeResults.txt");
	p9.detectPalindromes();
	cout << "done!" << endl;
}
