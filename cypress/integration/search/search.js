/// <reference types="cypress" />

import{Given, When, Then} from 'cypress-cucumber-preprocessor/steps'
import homepage from './homepage';

Given('I should open zero bank homepage', () => {
    homepage.visit()
})

When('I input data and submit in searchbox', () => {
    homepage.searchbox('Zero {enter}')
})

Then('I should have a result search', () => {
    cy.contains('Search Results:').should('be.visible')
})
