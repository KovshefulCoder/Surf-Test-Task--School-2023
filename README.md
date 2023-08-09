# Cocktail Bar 🍸

Cocktail Bar - это приложение, которое позволяет пользователям создавать и сохранять свои любимые коктейли в одном месте. Благодаря этому приложению, пользователи смогут добавлять информацию о каждом коктейле, такую как название, описание, список ингредиентов и рецепт его приготовления, а также хранить их на своем телефоне!

## Демонстрация

### Скриншоты

<img src="https://github.com/KovshefulCoder/Surf-Test-Task--School-2023/assets/84292117/d1087be1-976d-4d90-8eb4-1b593f8eb066" width="200">
<img src="https://github.com/KovshefulCoder/Surf-Test-Task--School-2023/assets/84292117/3e9ed722-afc7-40e0-bb37-0b076f1e525d" width="200">
<img src="https://github.com/KovshefulCoder/Surf-Test-Task--School-2023/assets/84292117/dbe43118-94dc-448e-9651-cd1fccbb6c9d" width="200">
<img src="https://github.com/KovshefulCoder/Surf-Test-Task--School-2023/assets/84292117/61459551-a7b3-4e8e-9516-f1bd553017f9" width="200">
<img src="https://github.com/KovshefulCoder/Surf-Test-Task--School-2023/assets/84292117/8092a846-87e0-4114-b98e-df8ba424b32f" width="200">
<img src="https://github.com/KovshefulCoder/Surf-Test-Task--School-2023/assets/84292117/d9ae0dd0-f556-416d-b0bd-345fa9263c9e" width="200">
<img src="https://github.com/KovshefulCoder/Surf-Test-Task--School-2023/assets/84292117/708e8d8c-c24a-4895-85c3-caec0f6fbf4d" width="200">


### Видео

https://github.com/KovshefulCoder/Surf-Test-Task--School-2023/assets/84292117/4673fe87-758f-4028-8681-44dd30879f0a

https://github.com/KovshefulCoder/Surf-Test-Task--School-2023/assets/84292117/088e4f65-ba5e-4a72-996e-0190286d2ed5

https://github.com/KovshefulCoder/Surf-Test-Task--School-2023/assets/84292117/80439f3d-3aa5-4019-9458-bb9cd64335a0

https://github.com/KovshefulCoder/Surf-Test-Task--School-2023/assets/84292117/5bf8e600-c3e4-4fd5-bfbb-b74f35cbb9a8

https://github.com/KovshefulCoder/Surf-Test-Task--School-2023/assets/84292117/f90dfaab-3a17-40f8-b12b-1c834e48b5b0

[Ссылка на последнее видео в Google Disk](https://drive.google.com/file/d/1sQXrhsvZzB-o7J-ldNoVVvm9rl3n2_kE/view?usp=sharing)




## Стек
* Kotlin
* Jetpack Compose
* MVVM
* Compose navigation
* Hilt
* Room
* Material/Material 3 elements

## Что реализовано

* **UI**: Полностью реализован весь интерфейс приложения и вся логика навигации в нем. В частности все кнопки ведут к нужным экранам, валидация обязательных полей, Bottom Sheet фиксированного размера с прокручиваемым содержимым, контейнер с вырезом под FAB.
* **Логика работы**: После первого открытия показан приветственный экран, по нажатию на + открывается форма создания коктеля, при сохранении открывается главное меню с сохраненным коктелем. **При повтором запуске приложения приветственный экран не открывается**, так как пользователь уже сохранил коктели.
* **Создание коктеля**: Из главного экрана при нажатии на FAB можно создать новый коктель.
* **Редактирование коктеля**: По нажатию на коктель в главном меню открывается его описание в Bottom Sheet, в котором есть кнопка EDIT. По нажатии по ней открывается форма редактирования коктеля, введенные в ней значения параметров коктеля будут перезаписаны в выбранный коктель при нажатии на кнопку SAVE.
* **Контейнер для FAB**: На экране главного меню реализован контейнер с вырезкой для FAB по дизайну
* **Имплементация Room**: Полностью имплементированы все интерфейсы и настройки для работы с коктелями **и ингридиентами**, в дальнейшем останется только использовать их.

## Что не реализовано

* Логика создания коктеля работает корректно, однако из-за крайне неочевидной [особенности Room](https://stackoverflow.com/questions/44109700/how-to-make-primary-key-as-autoincrement-for-room-persistence-lib#:~:text=A%20note%20for%20future%20readers%20%2D%20the%20primary%20key%20must%20be%200%20for%20Room%20to%20treat%20it%20as%20unset.%20If%20you%20use%20any%20other%20default%20value%20(e.g.%20%2D1)%2C%20Room%20will%20not%20autogenerate%20the%20id.), при записи в базу данных введеные значения перезаписываются в уже созданный коктель. Поправлено в ветке [after-shock](https://github.com/KovshefulCoder/Surf-Test-Task--School-2023/tree/after-shock).
* Логика редактирования коктеля работает корректно, однако прошлые параметры коктеля не переносятся на экран редактирования.
* Нет логики работы с ингридиентами, коктелю нельзя добавить и соответственно удалить их.
