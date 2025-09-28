package my.drivebit.clients.theme

object WebTheme {
    fun getWebStyles(): String {
        return """
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Inter', -apple-system, BlinkMacSystemFont, sans-serif;
        }
        body {
            color: #1a1a1a;
            line-height: 1.6;
            background-color: #ffffff;
            font-size: 16px;
            font-weight: 400;
        }
        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 20px;
        }
        /* Шапка */
        header {
            background-color: #ffffff;
            box-shadow: 0 1px 3px rgba(0,0,0,0.1);
            padding: 12px 0;
            position: sticky;
            top: 0;
            z-index: 1000;
            backdrop-filter: blur(10px);
        }
        .header-content {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .logo {
            display: flex;
            align-items: center;
            gap: 8px;
            text-decoration: none;
        }
        .logo img {
            height: 32px;
            width: auto;
        }
        .logo span {
            font-size: 24px;
            font-weight: 700;
            color: #2563eb;
        }
        nav ul {
            display: flex;
            list-style: none;
            gap: 25px;
        }
        nav ul li a {
            text-decoration: none;
            color: #4b5563;
            font-weight: 500;
            transition: all 0.3s ease;
            padding: 6px 12px;
            border-radius: 8px;
            font-size: 14px;
        }
        nav ul li a:hover {
            color: #2563eb;
            background-color: #f8fafc;
        }
        .auth-buttons {
            display: flex;
            gap: 10px;
            align-items: center;
        }
        .auth-buttons a {
            padding: 8px 18px;
            border-radius: 8px;
            text-decoration: none;
            font-weight: 500;
            transition: all 0.3s ease;
            font-size: 13px;
        }
        .auth-buttons .login {
            color: #2563eb;
            border: 1.5px solid #2563eb;
        }
        .auth-buttons .login:hover {
            background-color: #2563eb;
            color: white;
        }
        .auth-buttons .register {
            background-color: #f59e0b;
            color: white;
            border: 1.5px solid #f59e0b;
        }
        .auth-buttons .register:hover {
            background-color: #e6900b;
        }
        /* Герой секция */
        .hero {
            background-image: url('images/backgrounds/картинка.jpg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            min-height: 75vh;
            position: relative;
            overflow: hidden;
        }
        .hero::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background: rgba(0, 0, 0, 0.4);
            z-index: 1;
        }
        .hero-content {
            position: relative;
            z-index: 2;
            width: 100%;
            padding: 15px 20px;
            margin-top: 15px;
        }
        /* Форма поиска */
        .search-form {
            background: rgba(255, 255, 255, 0.95);
            border-radius: 25px;
            padding: 0;
            max-width: 900px;
            margin: 0 auto;
            box-shadow: 0 20px 40px rgba(0,0,0,0.1);
            display: flex;
            align-items: center;
            gap: 8px;
            backdrop-filter: blur(10px);
            overflow: hidden;
            border: 1px solid #e5e7eb;
            height: 50px;
        }
        .form-group {
            flex: 1;
            display: flex;
            flex-direction: column;
            padding: 10px 14px;
            min-width: 0;
        }
        .form-group label {
            margin-bottom: 2px;
            color: #374151;
            font-size: 11px;
            font-weight: 500;
            line-height: 1.2;
        }
        .form-group input, .form-group select {
            padding: 0;
            border: none;
            outline: none;
            font-size: 15px;
            background: transparent;
            color: #1a1a1a;
            height: 100%;
            box-sizing: border-box;
        }
        .search-btn {
            width: 50px;
            height: 50px;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            border: none;
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            cursor: pointer;
            transition: all 0.3s ease;
            margin-left: 4px;
        }
        .search-btn:hover {
            transform: scale(1.05);
            box-shadow: 0 4px 12px rgba(102, 126, 234, 0.3);
        }
        /* Преимущества */
        .features {
            padding: 60px 0;
            background: linear-gradient(to bottom, #ffffff, #f8fafc);
        }
        .section-title {
            text-align: center;
            margin-bottom: 48px;
        }
        .section-title h2 {
            font-size: 2.5rem;
            color: #1f2937;
            margin-bottom: 16px;
            font-weight: 700;
        }
        .section-title p {
            color: #6b7280;
            max-width: 800px;
            margin: 0 auto;
            font-size: 1.1rem;
            line-height: 1.6;
        }
        .features-grid {
            display: grid;
            grid-template-columns: repeat(4, 1fr);
            gap: 16px;
            margin: 0 auto;
            max-width: 1100px;
            padding: 0 20px;
        }
        .feature-card {
            background: white;
            padding: 28px 20px;
            border-radius: 20px;
            text-align: center;
            box-shadow: 0 4px 20px rgba(0,0,0,0.08);
            transition: all 0.3s ease;
            border: 1px solid #f1f5f9;
            font-size: 14px;
        }
        .feature-card:hover {
            transform: translateY(-6px);
            box-shadow: 0 20px 40px rgba(0,0,0,0.12);
        }
        .feature-icon {
            width: 60px;
            height: 60px;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            border-radius: 16px;
            display: flex;
            align-items: center;
            justify-content: center;
            margin: 0 auto 16px;
            color: white;
            font-size: 24px;
            font-weight: bold;
        }
        .feature-card h3 {
            margin-bottom: 12px;
            color: #1f2937;
            font-size: 1.2rem;
            font-weight: 600;
        }
        .feature-card p {
            color: #6b7280;
            line-height: 1.5;
        }
        /* Популярные автомобили */
        .popular-cars {
            padding: 100px 0;
            background: linear-gradient(to bottom, #f8fafc, #ffffff);
        }
        .cars-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(320px, 1fr));
            gap: 32px;
            margin-top: 48px;
        }
        .car-card {
            background: white;
            border-radius: 20px;
            overflow: hidden;
            box-shadow: 0 4px 20px rgba(0,0,0,0.08);
            transition: all 0.3s ease;
            border: 1px solid #f1f5f9;
        }
        .car-card:hover {
            transform: translateY(-8px);
            box-shadow: 0 20px 40px rgba(0,0,0,0.12);
        }
        .car-image {
            width: 100%;
            height: 220px;
            object-fit: cover;
        }
        .car-details {
            padding: 28px;
        }
        .car-title {
            font-size: 1.3rem;
            color: #1f2937;
            margin-bottom: 8px;
            font-weight: 600;
        }
        .car-location {
            color: #6b7280;
            font-size: 14px;
            margin-bottom: 16px;
            display: flex;
            align-items: center;
            gap: 6px;
        }
        .car-price {
            font-size: 1.8rem;
            color: #2563eb;
            font-weight: 700;
            margin-bottom: 20px;
        }
        .car-price span {
            font-size: 1rem;
            color: #6b7280;
            font-weight: 400;
        }
        .car-features {
            margin-bottom: 24px;
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 12px;
        }
        .car-feature {
            display: flex;
            align-items: center;
            color: #6b7280;
            font-size: 14px;
            gap: 8px;
        }
        .car-feature::before {
            content: "✓";
            color: #10b981;
            font-weight: bold;
            font-size: 16px;
        }
        .book-btn {
            display: block;
            width: 100%;
            padding: 16px;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            text-decoration: none;
            text-align: center;
            border-radius: 12px;
            font-weight: 600;
            transition: all 0.3s ease;
            border: none;
            cursor: pointer;
        }
        .book-btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 8px 20px rgba(102, 126, 234, 0.3);
        }
        .view-more-btn {
            display: block;
            margin: 48px auto 0;
            text-align: center;
            background: linear-gradient(135deg, #2563eb 0%, #1d4ed8 100%);
            color: white;
            padding: 18px 36px;
            border-radius: 12px;
            font-size: 1.1rem;
            font-weight: 600;
            text-decoration: none;
            transition: all 0.3s ease;
            width: fit-content;
        }
        .view-more-btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 12px 30px rgba(37, 99, 235, 0.3);
        }
        /* Для владельцев */
        .for-owners {
            padding: 100px 0;
            background: white;
        }
        /* Призыв к действию */
        .cta {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 100px 0;
            text-align: center;
            position: relative;
            overflow: hidden;
        }
        .cta h2 {
            font-size: 2.8rem;
            margin-bottom: 24px;
            font-weight: 700;
        }
        .cta p {
            max-width: 600px;
            margin: 0 auto 40px;
            font-size: 1.25rem;
            opacity: 0.95;
            font-weight: 300;
        }
        .cta .btn {
            background: white;
            color: #2563eb;
            font-size: 1.1rem;
            padding: 18px 36px;
            font-weight: 600;
            border-radius: 12px;
            text-decoration: none;
            transition: all 0.3s ease;
            display: inline-block;
        }
        .cta .btn:hover {
            background: #f8fafc;
            transform: translateY(-2px);
            box-shadow: 0 12px 30px rgba(255, 255, 255, 0.2);
        }
        /* Футер */
        footer {
            background-color: #1f2937;
            color: #f8f9fa;
            padding: 80px 0 20px;
        }
        .footer-content {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 48px;
            margin-bottom: 48px;
        }
        .footer-column h3 {
            font-size: 1.3rem;
            margin-bottom: 24px;
            color: white;
            font-weight: 600;
        }
        .footer-column p {
            color: #d1d5db;
            line-height: 1.6;
            margin-bottom: 24px;
            font-size: 15px;
        }
        .footer-column ul {
            list-style: none;
        }
        .footer-column ul li {
            margin-bottom: 12px;
        }
        .footer-column ul li a {
            color: #d1d5db;
            text-decoration: none;
            transition: color 0.3s ease;
            font-size: 15px;
        }
        .footer-column ul li a:hover {
            color: white;
        }
        .copyright {
            text-align: center;
            padding-top: 40px;
            border-top: 1px solid #374151;
            color: #9ca3af;
            font-size: 14px;
        }
        /* Новая кнопка внизу */
        .blog-cta {
            text-align: center;
            padding: 60px 20px;
            background: #f8fafc;
            margin-top: 0;
        }
        .blog-btn {
            display: inline-block;
            background: #f59e0b;
            color: white;
            padding: 16px 32px;
            border-radius: 12px;
            font-size: 1.1rem;
            font-weight: 600;
            text-decoration: none;
            transition: all 0.3s ease;
        }
        .blog-btn:hover {
            background: #e6900b;
            transform: translateY(-2px);
            box-shadow: 0 8px 20px rgba(245, 158, 11, 0.2);
        }
        /* Адаптивность */
        @media (max-width: 768px) {
            .header-content {
                flex-direction: column;
                gap: 15px;
                text-align: center;
            }
            nav ul {
                flex-direction: column;
                gap: 12px;
            }
            .auth-buttons {
                justify-content: center;
                flex-wrap: wrap;
            }
            .features-grid {
                grid-template-columns: repeat(2, 1fr);
            }
            .cars-grid {
                grid-template-columns: 1fr;
            }
            .car-features {
                grid-template-columns: 1fr;
            }
            .footer-content {
                grid-template-columns: 1fr;
            }
        }
        """
    }

    fun getWebScripts(): String {
        return """
        // Установка минимальной даты
        const today = new Date().toISOString().split('T')[0];
        const startDateInput = document.getElementById('start-date');
        const endDateInput = document.getElementById('end-date');
        
        if (startDateInput) startDateInput.setAttribute('min', today);
        if (endDateInput) endDateInput.setAttribute('min', today);
        
        // Обновление минимальной даты для даты возврата
        if (startDateInput && endDateInput) {
            startDateInput.addEventListener('change', function() {
                if (this.value) {
                    endDateInput.setAttribute('min', this.value);
                }
            });
        }
        
        // Плавная прокрутка по якорям
        document.querySelectorAll('a[href^="#"]').forEach(anchor => {
            anchor.addEventListener('click', function (e) {
                e.preventDefault();
                const target = document.querySelector(this.getAttribute('href'));
                if (target) {
                    window.scrollTo({
                        top: target.offsetTop - 80,
                        behavior: 'smooth'
                    });
                }
            });
        });
        """
    }
}
