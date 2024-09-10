import './style.css'
import * as css from './button.module.css';
import logoPng from './assets/react_logo.png';

const rootElement = document.getElementById('root');

const divElement = document.createElement('div');
divElement.classList.add('layout');

const buttonElement = document.createElement('button');
buttonElement.innerHTML = 'Click Me';
buttonElement.classList.add(css.button)
buttonElement.addEventListener('click', () => alert('Button has been clicked'))

divElement.appendChild(buttonElement)
rootElement.appendChild(divElement);

const imageElement = document.createElement('img')
imageElement.src = logoPng;
imageElement.style.width = '200px';
imageElement.style.height = '200px';

divElement.appendChild(imageElement)
