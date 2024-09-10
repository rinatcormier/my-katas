import './style.css'
import * as css from './button.module.css';

const rootElement = document.getElementById('root');

const divElement = document.createElement('div');
divElement.classList.add('layout');

const buttonElement = document.createElement('button');
buttonElement.innerHTML = 'Click Me';
buttonElement.classList.add(css.button)
buttonElement.addEventListener('click', () => alert('Button has been clicked'))

divElement.appendChild(buttonElement)
rootElement.appendChild(divElement);
