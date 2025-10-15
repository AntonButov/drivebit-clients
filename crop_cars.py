#!/usr/bin/env python3
"""
Скрипт для обрезки фотографий автомобилей в соотношении 2.3:1
Как в Turo - широкие горизонтальные изображения
"""

import os
import sys
from PIL import Image
import argparse

def crop_to_ratio(image_path, output_path, target_ratio=2.3):
    """
    Обрезает изображение до соотношения 2.3:1 (ширина:высота)
    Центрирует изображение и обрезает края
    """
    try:
        # Открываем изображение
        with Image.open(image_path) as img:
            print(f"Обрабатываем: {os.path.basename(image_path)}")
            print(f"  Исходный размер: {img.size[0]}x{img.size[1]}")
            
            # Получаем размеры
            original_width, original_height = img.size
            
            # Вычисляем размеры для целевого соотношения
            if original_width / original_height > target_ratio:
                # Изображение слишком широкое - обрезаем по бокам
                new_height = original_height
                new_width = int(original_height * target_ratio)
                
                # Центрируем
                left = (original_width - new_width) // 2
                top = 0
                right = left + new_width
                bottom = original_height
                
            else:
                # Изображение слишком высокое - обрезаем сверху и снизу
                new_width = original_width
                new_height = int(original_width / target_ratio)
                
                # Центрируем
                left = 0
                top = (original_height - new_height) // 2
                right = original_width
                bottom = top + new_height
            
            # Обрезаем изображение
            cropped_img = img.crop((left, top, right, bottom))
            
            # Сохраняем результат
            cropped_img.save(output_path, quality=95, optimize=True)
            
            print(f"  Обрезано до: {cropped_img.size[0]}x{cropped_img.size[1]}")
            print(f"  Сохранено: {output_path}")
            print(f"  Соотношение: {cropped_img.size[0]/cropped_img.size[1]:.2f}:1")
            print()
            
            return True
            
    except Exception as e:
        print(f"Ошибка при обработке {image_path}: {e}")
        return False

def process_cars_folder(input_folder, output_folder=None):
    """
    Обрабатывает все изображения в папке с автомобилями
    """
    if not os.path.exists(input_folder):
        print(f"Папка не найдена: {input_folder}")
        return
    
    # Создаем выходную папку
    if output_folder is None:
        output_folder = os.path.join(input_folder, "cropped")
    
    os.makedirs(output_folder, exist_ok=True)
    
    # Поддерживаемые форматы
    supported_formats = ('.jpg', '.jpeg', '.png', '.bmp', '.tiff')
    
    # Находим все изображения
    image_files = []
    for file in os.listdir(input_folder):
        if file.lower().endswith(supported_formats):
            image_files.append(file)
    
    if not image_files:
        print(f"В папке {input_folder} не найдено изображений")
        return
    
    print(f"Найдено {len(image_files)} изображений для обработки")
    print(f"Выходная папка: {output_folder}")
    print(f"Целевое соотношение: 2.3:1")
    print("-" * 50)
    
    success_count = 0
    
    for image_file in image_files:
        input_path = os.path.join(input_folder, image_file)
        
        # Создаем имя выходного файла
        name, ext = os.path.splitext(image_file)
        output_filename = f"{name}_cropped{ext}"
        output_path = os.path.join(output_folder, output_filename)
        
        # Обрабатываем изображение
        if crop_to_ratio(input_path, output_path):
            success_count += 1
    
    print("-" * 50)
    print(f"Обработано успешно: {success_count}/{len(image_files)} изображений")
    print(f"Результаты сохранены в: {output_folder}")

def main():
    parser = argparse.ArgumentParser(description='Обрезка фотографий автомобилей в соотношении 2.3:1')
    parser.add_argument('--input', '-i', 
                       default='/Users/antonbutov/Downloads/CARS',
                       help='Путь к папке с изображениями (по умолчанию: /Users/antonbutov/Downloads/CARS)')
    parser.add_argument('--output', '-o',
                       help='Путь к выходной папке (по умолчанию: input_folder/cropped)')
    parser.add_argument('--ratio', '-r', type=float, default=2.3,
                       help='Целевое соотношение ширины к высоте (по умолчанию: 2.3)')
    
    args = parser.parse_args()
    
    print("🚗 Обрезка фотографий автомобилей")
    print("=" * 50)
    
    # Проверяем наличие PIL
    try:
        from PIL import Image
    except ImportError:
        print("❌ Ошибка: Не установлен модуль Pillow")
        print("Установите его командой: pip install Pillow")
        sys.exit(1)
    
    # Обрабатываем изображения
    process_cars_folder(args.input, args.output)

if __name__ == "__main__":
    main()
