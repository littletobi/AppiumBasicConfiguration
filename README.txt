http://www.automationtestinghub.com

adb devices => stad bierzemy id mobilki
adb shell => teraz uruchamiam szukana apke w mobilce i z ponizszymi moge znalezc appPackage i appActivity/mozna spróbowac APK Info
dumpsys window windows | grep -E ‘mCurrentFocus’  albo dumpsys window windows | grep -E ‘mFocusedApp’

Uruchamimy Appium server => warto zaznaczyc nadpisywanie sesji
uiautomatorviewer => wpisane w konsoli i mozna identyfikowac obiekty w apce

Appium desktop inspector => kliknij na ikonke lupy w konsoli Apium servera.
Dodaj wszysktie capability do podlaczenia i start session

