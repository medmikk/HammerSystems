# Pizza App
### Тестовое задание на собеседование в Hammer Systems
последнее изменение - 15.10.2022

#### Ссылки
 - Макет [(Figma)](https://www.figma.com/file/8FvAWXCD2oD9oSDHx9xFfU/%D0%A2%D0%B5%D1%81%D1%82%D0%BE%D0%B2%D0%BE%D0%B5-%D0%B7%D0%B0%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5-Android?node-id=0%3A1 ) 
 - API [ (spoonacular.com)](https://spoonacular.com/food-api/docs#Search-Menu-Items) 

#### Описание
Проект представляет из себя дизайн главной страницы приложения пиццерии. Изображения в баннеры выполнены посредством хардкода. Содержимое меню предоставляет API spoonacular.com. Посредством CollapsingToolbarLayout была реализована планка категорий, которая "прилипает" к верхнему бару с городом и значком qr-кода. Т.к. API не предоставляет описание блюда, было принято решение заменить его на название ресторана, в котором продается блюдо, а цену генерировань в пределах 150-450 рублей случайным образом при входе в приложение. Т.к. проект не имеет четко поставленного ТЗ, я решил выводить первые 10 пицц, которые пришли в результате запроса к API.

#### Стек
- Retrofit2
- MVVM
- Clean Architecture

#### Скриншоты
<img width="270" src="https://github.com/medmikk/HammerSystems/blob/58e088d41216071f974adc030c78951f6451b489/readme%20files/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20(82).png"> | <img width="270" src="https://github.com/medmikk/HammerSystems/blob/c7e7666495562dabc20ea44c92fe5c09d265131e/readme%20files/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20(83).png">
